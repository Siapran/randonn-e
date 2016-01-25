/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.item.tool;

import rpg.utils.Holder;
import rpg.utils.Named;

@Named(name = "mains nues")
public class Hand extends Weapon {

    private Hand(Holder holder) {
        super(holder, CONDITION_MAX, 0);
    }
    
    // dummy instance to simplify semantics
    public static Hand getInstance() {
        return HandHolder.INSTANCE;
    }

    // here, hold my hand
    private static class HandHolder {
        private static final Hand INSTANCE = new Hand(null);
    }
    
    @Override
    public String toString() {
        return "mains nues";
    }

    @Override
    public int getDamage() {
        return 50;
    }
    
}
