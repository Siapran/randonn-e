/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.item.fuel;

import rpg.utils.Holder;
import rpg.utils.Named;
import rpg.world.entity.item.Fuel;

@Named(name = "brindille")
public class Stick extends Fuel {

    public Stick(Holder holder) {
        super(10, 100, holder, CONDITION_MAX, 100);
    }

    @Override
    public String toString() {
        return "brindille";
    }
    
}
