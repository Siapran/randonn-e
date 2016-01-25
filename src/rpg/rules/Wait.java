/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.rules;

import rpg.utils.Named;
import rpg.world.entity.Actor;

@Named(name = "attendre")
public class Wait extends Action {

    public Wait(Actor actor) {
        super(actor);
    }

    @Override
    public void update() {
        --timeleft;
    }

    @Override
    public int getCost() {
        return 2;
    }
    
}
