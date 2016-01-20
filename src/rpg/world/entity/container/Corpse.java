/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.container;

import rpg.utils.Named;
import rpg.utils.Tracker;
import rpg.world.Location;
import rpg.world.entity.Container;

@Named(name = "cadavre")
public class Corpse extends Container {

    private final String name;
    double condition;

    public Corpse(String name, Location location) {
        super(location);
        this.name = name;
    }

    public Corpse(String name, Location location, Tracker contents) {
        super(location, contents);
        this.name = name;
    }

    @Override
    public void update() {
        super.update();
        --condition;
        if (condition <= 0) {
            destroy();
        }
    }

    @Override
    public String toString() {
        return "Cadavre (" + name + ")";
    }

}
