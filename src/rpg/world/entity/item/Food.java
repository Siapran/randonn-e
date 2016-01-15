/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.item;

import rpg.utils.Holder;
import rpg.world.entity.Item;


public abstract class Food extends Item {
    
    private final double calories;

    public Food(double calories, Holder holder, double condition, double weight) {
        super(holder, condition, weight);
        this.calories = calories;
    }

    

    public double getCalories() {
        return calories;
    }

    @Override
    public void update() {
        --condition;
        super.update();
    }

    
    
}
