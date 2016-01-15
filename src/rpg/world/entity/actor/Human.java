/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.actor;

import rpg.world.entity.Actor;
import rpg.world.Location;


public class Human extends Actor {

    private final String name;

    public Human(String name, Location currentLocation) {
        super(currentLocation);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void destroy() {
        super.destroy();
    }



    
}
