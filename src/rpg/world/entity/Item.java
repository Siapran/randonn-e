/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity;

import rpg.utils.Holder;
import rpg.world.Entity;

public abstract class Item extends Entity {

    protected double condition;
    protected double weight;

    public Item(Holder holder, double condition, double weight) {
        super(holder);
        this.condition = condition;
        this.weight = weight;
    }

    @Override
    public void update() {
        if (condition <= 0) {
            destroy();
        }
    }
    
    
    
}
