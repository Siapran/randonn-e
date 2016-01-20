/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.item.food;

import rpg.utils.Cookable;
import rpg.utils.Holder;
import rpg.utils.Named;
import rpg.world.World;
import rpg.world.entity.item.Food;

@Named(name = "viande crue")
public class RawMeat extends Food implements Cookable {

    public RawMeat(Holder holder, int condition, int weight) {
        super(weight, holder, condition, weight);
    }

    @Override
    public String toString() {
        return "viande crue";
    }

    @Override
    public void replaceWithCookedProduct() {
        World.spawn(new CookedMeat(getHolder(), CONDITION_MAX, weight));
        this.destroy();
    }

}
