/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.item.food;

import rpg.utils.Holder;
import rpg.utils.Named;

@Named(name = "viande en boîte")
public class CannedMeat extends Canned {

    public CannedMeat(Holder holder, int condition) {
        super(500, holder, condition, 500);
    }

    @Override
    public String toString() {
        return "viande en boîte";
    }
    
}
