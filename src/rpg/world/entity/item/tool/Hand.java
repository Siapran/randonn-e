/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.item.tool;

import rpg.utils.Holder;
import rpg.utils.Named;
import rpg.world.entity.item.Tool;

@Named(name = "mains nues")
public abstract class Hand extends Tool {

    public Hand(Holder holder) {
        super(holder, CONDITION_MAX, 0);
    }
    
    // this class should never be instanciated
    @Override
    public String toString() {
        return "mains nues";
    }
    
}
