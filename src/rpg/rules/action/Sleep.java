/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.rules.action;

import rpg.rules.Action;
import rpg.utils.Named;
import rpg.world.entity.Actor;

@Named(name = "dormir")
public class Sleep extends Action {

    private final int time;

    public Sleep(int time, Actor actor) {
        super(actor);
        this.time = time;
        postConstructionInit();
    }

    @Override
    public int getCost() {
        return time;
    }

    @Override
    public void update() {
        --timeleft;
        Actor actor = getActor();
        actor.setWeariness(actor.getWeariness() + 3); // sleep recovery
    }

}
