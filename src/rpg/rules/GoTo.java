/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.rules;

import rpg.world.entity.Actor;
import rpg.world.Location;


public class GoTo extends Action {

    public GoTo(String name, Location from, Actor actor, Location to) {
        super(name, from, actor, to);
    }

    @Override
    public void doEffect() {
        
    }

    @Override
    public int getCost() {
        
    }

    @Override
    public double getProbability() {
        return ALWAYS;
    }


    
}
