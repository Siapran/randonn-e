/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.item.food;

import rpg.utils.Holder;
import rpg.utils.Named;
import rpg.world.entity.item.Food;

@Named(name = "boîte de conserve")
public abstract class Canned extends Food {

    private boolean opened;
    
    public Canned(int calories, Holder holder, int condition, int weight) {
        super(calories, holder, condition, weight);
    }

    public boolean isOpened() {
        return opened;
    }

    public void open() {
        this.opened = true;
    }

    
}
