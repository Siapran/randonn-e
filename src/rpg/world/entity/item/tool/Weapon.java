/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.item.tool;

import rpg.utils.Holder;
import rpg.utils.Named;
import rpg.world.entity.item.Tool;

@Named(name = "arme")
public abstract class Weapon extends Tool {

    public Weapon(Holder holder, int condition, int weight) {
        super(holder, condition, weight);
    }
    
    public abstract int getDamage();
    
}
