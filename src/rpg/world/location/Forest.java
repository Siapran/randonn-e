/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.location;

import rpg.utils.Named;
import rpg.utils.Util;
import rpg.world.World;
import rpg.world.entity.item.fuel.Stick;

@Named(name = "forêt")
public class Forest extends OutdoorLocation {

    public Forest(String name) {
        super(name);
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {
        super.update();
        // branches fall from trees
        if (getTracker().filterType(Stick.class).stream().count() <= 10) {
            if (Util.rand(2)) {
                World.spawn(new Stick(this));
            }
        }
    }

}
