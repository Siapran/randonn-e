/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.rules;

import rpg.utils.Named;
import rpg.world.entity.Actor;

/**
 *
 * @author siapran
 */
@Named(name = "action")
public abstract class Action {
    
    public static final double NEVER = 0;
    public static final double ALWAYS = 100;
    
    private final Actor actor;
    protected int timeleft;

    public Action(Actor actor) {
        this.actor = actor;
    }

    protected final void postConstructionInit() {
        timeleft = getCost();
    }
    
    public abstract void update();

    public boolean isDone() {
        return timeleft <= 0;
    }
    
    public abstract int getCost(); // nombre de tours nécessaires à l'action

    public final Actor getActor() {
        return actor;
    }

}
