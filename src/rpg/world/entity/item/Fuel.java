/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.item;

import rpg.utils.Holder;
import rpg.world.entity.Item;


public abstract class Fuel extends Item {

    private final double burnTime;
    private final double flamability;

    public Fuel(double burnTime, double flamability, Holder holder, double condition, double weight) {
        super(holder, condition, weight);
        this.burnTime = burnTime;
        this.flamability = flamability;
    }

    
    
}
