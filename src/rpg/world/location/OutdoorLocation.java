/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.location;

import rpg.utils.Named;
import rpg.world.Location;
import rpg.world.World;

@Named(name = "dehors")
public abstract class OutdoorLocation extends Location {

    public OutdoorLocation(String name) {
        super(name, World.getInstance().getOutdoorTemperature(), World.getInstance().getWind());
    }

    @Override
    public void update() {
        setTemperature(World.getInstance().getOutdoorTemperature());
        setWind(World.getInstance().getWind());
    }

}
