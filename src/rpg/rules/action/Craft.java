/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.rules.action;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import rpg.rules.Action;
import rpg.utils.Craftable;
import rpg.utils.InsufficientHoldCapability;
import rpg.utils.Named;
import rpg.utils.Tracker;
import rpg.world.entity.Actor;
import rpg.world.entity.Item;
import rpg.world.entity.item.Tool;

@Named(name = "fabriquer")
public class Craft extends Action {

    private final Map<Class<? extends Item>, Integer> ingredients;
    private final Tool tool;

    private final Craftable target;

    public Craft(Map<Class<? extends Item>, Integer> ingredients, Tool tool, Craftable target, Actor actor) {
        super(actor);
        this.ingredients = ingredients;
        this.tool = tool;
        this.target = target;
    }

    @Override
    public void update() {
        --timeleft;
        Item targetItem = (Item) target;
        targetItem.setCondition(Item.CONDITION_MAX); // keep the item from decaying

        if (timeleft <= 0) {
            Tracker inventory = getActor().getTracker();

            // INGREDIENTS REMOVAL
            // we assume the actor has all the ingredients needed
            // for each ingredient
            ingredients.entrySet().stream().forEach((entry) -> {
                Class<? extends Item> itemType = entry.getKey();
                Integer count = entry.getValue();
                // remove the requested number of items of the current type from the actor's inventory
                inventory.filterType(itemType).stream().limit(count).forEach((item) -> {
                    item.destroy();
                });
            });

            tool.setCondition(tool.getCondition() - 100);

            try {
                targetItem.moveTo(getActor()); // give the actor the crafted item
            } catch (InsufficientHoldCapability ex) {
                Logger.getLogger(Craft.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public int getCost() {
        return 10; // TODO: implement per item cost
    }

}
