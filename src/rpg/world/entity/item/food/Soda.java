/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.item.food;

import rpg.utils.Holder;
import rpg.utils.Named;
import rpg.world.entity.item.Food;

@Named(name = "soda")
public class Soda extends Food {

    public Soda(Holder holder, int condition) {
        super(250, 250, holder, condition, 250);
    }

    @Override
    public String toString() {
        return "soda";
    }
    
}
