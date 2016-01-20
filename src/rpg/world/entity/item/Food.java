/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.item;

import rpg.utils.Holder;
import rpg.utils.Named;
import rpg.world.entity.Item;

@Named(name = "nourriture")
public abstract class Food extends Item {

    private final int calories;
    private final int moisture;

    public Food(int calories, Holder holder, int condition, int weight) {
        super(holder, condition, weight);
        this.calories = calories;
        this.moisture = 0;
    }

    public Food(int calories, int moisture, Holder holder, int condition, int weight) {
        super(holder, condition, weight);
        this.calories = calories;
        this.moisture = moisture;
    }
    

    public int getCalories() {
        return calories;
    }

    @Override
    public void update() {
        condition.setValue(condition.getValue() - 1);
        super.update();
    }

}
