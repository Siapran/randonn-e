/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.location;

import rpg.utils.Named;
import rpg.utils.Tracker;
import rpg.world.Location;

/**
 *
 * @author siapran
 */
@Named(name = "interieur")
public abstract class IndoorLocation extends Location {

    public IndoorLocation(String name, Tracker edges, int temperature, int windchill) {
        super(name, edges, temperature, windchill);
    }

    @Override
    public void setWind(int wind) {
        super.setWind(0);
    }

    @Override
    public int getWind() {
        return 0;
    }

    @Override
    public void update() {
    }

}
