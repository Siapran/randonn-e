/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.container;

import rpg.utils.Named;
import rpg.world.Location;
import rpg.world.entity.Container;

@Named(name = "sac à dos")
public class Backpack extends Container {

    public Backpack(Location location) {
        super(location);
    }

    @Override
    public String toString() {
        return "sac à dos";
    }
    
}
