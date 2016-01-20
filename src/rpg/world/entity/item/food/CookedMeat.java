/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.item.food;

import rpg.utils.Holder;
import rpg.utils.Named;
import rpg.world.entity.item.Food;

@Named(name = "viande cuite")
public class CookedMeat extends Food {

    public CookedMeat(Holder holder, int condition, int weight) {
        super((int) (weight * 1.5), holder, condition, weight);
    }

    @Override
    public String toString() {
        return "viande cuite";
    }

}
