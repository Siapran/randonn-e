/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity;

import rpg.world.entity.container.Corpse;
import rpg.world.Location;
import rpg.rules.Action;
import rpg.utils.Holder;
import rpg.utils.Tracker;
import rpg.world.Entity;
import rpg.world.World;

/**
 *
 * @author siapran
 */
public abstract class Actor extends Entity implements Holder {

    private double health;
    private double bleedingTime;
    private Tracker inventory;
    private Action currentAction = null;

    public Actor(Location currentLocation) {
        super(currentLocation);
    }

    public void say(String message) {
        System.out.println("[" + this + "]: " + message);
    }

    public Location getCurrentLocation() {
        return (Location) getHolder();
    }

    @Override
    public void destroy() {
        // on death, spawn corspe with inventory at current location
        World.spawn(new Corpse(this.toString(), (Location) getHolder(), inventory));
        super.destroy();
    }

    @Override
    public Class<? extends Entity> getHoldCapability() {
        return Item.class;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getBleedingTime() {
        return bleedingTime;
    }

    public void setBleedingTime(double bleedingTime) {
        this.bleedingTime = bleedingTime;
    }

    public Tracker getInventory() {
        return inventory;
    }

    @Override
    public void update() {
        if (bleedingTime > 0) {
            --health;
            --bleedingTime;
            if (bleedingTime < 0) {
                bleedingTime = 0;
            }
        }
        if (health <= 0) {
            health = 0;
            destroy();
        }
    }

    @Override
    public Tracker getTracker() {
        return inventory;
    }

}
