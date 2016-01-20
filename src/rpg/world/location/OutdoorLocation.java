/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.location;

import rpg.utils.Named;
import rpg.utils.Tracker;
import rpg.world.Location;

@Named(name = "dehors")
public abstract class OutdoorLocation extends Location {

    public OutdoorLocation(String name, Tracker edges, int temperature, int windchill) {
        super(name, edges, temperature, windchill);
    }

    @Override
    public void update() {
    }
    
}
