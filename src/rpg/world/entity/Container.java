/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity;

import rpg.utils.Holder;
import rpg.utils.Named;
import rpg.utils.Tracker;
import rpg.world.Entity;
import rpg.world.Location;

@Named(name = "conteneur")
public abstract class Container extends Entity implements Holder {

    private final Tracker contents;

    public Container(Location location) {
        super(location);
        contents = new Tracker();
    }

    public Container(Location location, Tracker contents) {
        super(location);
        this.contents = contents;
    }

    public Tracker getContents() {
        return contents;
    }

    @Override
    public void update() {

    }

    @Override
    public void destroy() {
        contents.stream().forEach((item) -> {
            item.destroy();
        });
        super.destroy();
    }

    @Override
    public Class<? extends Entity> getHoldCapability() {
        return Item.class;
    }

    @Override
    public Tracker getTracker() {
        return contents;
    }

}
