/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.item.tool;

import rpg.utils.Holder;
import rpg.utils.Named;

@Named(name = "couteau")
public class Knife extends Weapon {

    public Knife(Holder holder, int condition) {
        super(holder, condition, 150);
    }

    @Override
    public String toString() {
        return "couteau";
    }

    @Override
    public int getDamage() {
        // more damage than a wolf
        return 150;
    }


    
}
