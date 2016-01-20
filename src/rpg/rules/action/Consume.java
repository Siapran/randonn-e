/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.rules.action;

import rpg.rules.Action;
import rpg.utils.Named;
import rpg.world.entity.Actor;
import rpg.world.entity.item.Food;

@Named(name = "consommer")
public class Consume extends Action {

    private final Food food;

    public Consume(Food food, Actor actor) {
        super(actor);
        this.food = food;
        postConstructionInit();
    }

    @Override
    public void update() {
        --timeleft;
        if (timeleft <= 0) {
            Actor actor = getActor();
            actor.setHunger((int) (actor.getHunger() + food.getCalories()));
            food.destroy();
        }
    }

    @Override
    public int getCost() {
        return 2;
    }
    
}
