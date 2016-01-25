/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.rules.action;

import java.util.logging.Level;
import java.util.logging.Logger;
import rpg.rules.Action;
import rpg.utils.InsufficientHoldCapability;
import rpg.utils.Named;
import rpg.world.entity.Actor;
import rpg.world.entity.Item;
import rpg.world.entity.actor.Player;

@Named(name = "prendre")
public class Take extends Action {

    private final Item item;

    public Take(Item item, Actor actor) {
        super(actor);
        this.item = item;
        postConstructionInit();
    }

    public void doEffect() {
        try {
            item.moveTo(getActor());
            if (getActor() instanceof Player) {
                Player player = (Player) getActor();
                System.out.println("Vous prenez: " + item + ".");
            }
        } catch (InsufficientHoldCapability ex) {
            Logger.getLogger(Take.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getCost() {
        return 1;
    }

    @Override
    public void update() {
        --timeleft;
        if (timeleft <= 0) {
            doEffect();
        }
    }

}
