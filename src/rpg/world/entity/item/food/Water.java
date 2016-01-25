/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.item.food;

import rpg.utils.Holder;
import rpg.utils.Named;
import rpg.world.entity.item.Food;

@Named(name = "bouteille d'eau")
public class Water extends Food {

    public Water(Holder holder, int condition, int weight) {
        super(0, weight, holder, condition, weight);
    }

    @Override
    public String toString() {
        return "bouteille d'eau";
    }
    
    
}
