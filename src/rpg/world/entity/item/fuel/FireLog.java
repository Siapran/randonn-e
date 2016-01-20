/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.item.fuel;

import rpg.utils.Holder;
import rpg.utils.Named;
import rpg.world.entity.item.Fuel;

@Named(name = "bûche")
public class FireLog extends Fuel {

    public FireLog(Holder holder) {
        super(120, 20, holder, CONDITION_MAX, 5000);
    }

    @Override
    public String toString() {
        return "bûche";
    }
    
}
