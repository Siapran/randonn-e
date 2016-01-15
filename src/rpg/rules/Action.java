/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.rules;

import java.util.HashMap;
import java.util.Map;
import rpg.world.entity.Actor;
import rpg.world.Location;

/**
 *
 * @author siapran
 */
public abstract class Action {

    public static final Map<String, Class<? extends Action>> NAMES = new HashMap<>();
    
    public static final double NEVER = 0;
    public static final double ALWAYS = 100;
    
    private final Location location;
    private final Actor actor;

    public Action(Location location, Actor actor) {
        this.location = location;
        this.actor = actor;
    }

    public abstract void parse(String[] args);

    public Location getLocation() {
        return location;
    }

    public abstract void doEffect();

    public abstract int getCost(); // nombre de tours nécessaires à l'action

    public Actor getActor() {
        return actor;
    }


    public abstract double getProbability(); // probabilité de réussir cette action pour ce contexte

}
