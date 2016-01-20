/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.item.tool;

import rpg.utils.Holder;
import rpg.utils.Named;

@Named(name = "hachette")
public class Hachet extends Weapon {

    public Hachet(Holder holder, int condition) {
        super(holder, condition, 500);
    }

    @Override
    public String toString() {
        return "hachette";
    }

    @Override
    public int getDamage() {
        return 100;
    }
    
}
