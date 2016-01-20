/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.item.tool;

import rpg.utils.Holder;
import rpg.utils.Named;
import rpg.world.entity.item.Tool;

@Named(name = "ouvre-boîte")
public class CanOpener extends Tool {

    public CanOpener(Holder holder, int condition) {
        super(holder, condition, 250);
    }

    @Override
    public String toString() {
        return "ouvre-boîte";
    }
    
}
