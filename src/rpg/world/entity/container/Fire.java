/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.container;

import rpg.utils.Named;
import rpg.world.Location;
import rpg.world.entity.Container;
import rpg.world.entity.item.Fuel;

@Named(name = "feu")
public class Fire extends Container {

    private int duration;

    public Fire(int duration, Location location) {
        super(location);
        this.duration = duration;
    }

    @Override
    public void update() {
        if (duration > 0) {
            --duration;
        } else {
            destroy();
        }
    }

    @Override
    public String toString() {
        return "feu";
    }

    public void addFuel(Fuel fuel) {
        this.duration += fuel.getBurnTime();
        fuel.destroy();
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String description() {
        String res = "";
        res += "Un " + this;
        if (duration == 0) {
            res += " éteint";
        } else {
            res += " qui peut brûler " + getDuration() + " minutes";
        }
        return res + ".";
    }

}
