/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity;

import rpg.world.entity.container.Carcass;
import rpg.world.Location;
import rpg.rules.Action;
import rpg.utils.Bound;
import rpg.utils.Holder;
import rpg.utils.Named;
import rpg.utils.Tracker;
import rpg.utils.Util;
import rpg.world.Entity;
import rpg.world.World;

/**
 *
 * @author siapran
 */
@Named(name = "acteur")
public abstract class Actor extends Entity implements Holder {

    public static final int STATUS_MAX = 1000;

    private final Bound<Integer> health;
    private final Bound<Integer> warmth;
    private final Bound<Integer> weariness;
    private final Bound<Integer> hunger;
    private final Bound<Integer> thirst;

    private int bleedingTime;
    private final Tracker inventory;

    Action currentAction = null;

    public Actor(Location currentLocation) {
        super(currentLocation);
        inventory = new Tracker();
        health = new Bound<>(STATUS_MAX, 0, STATUS_MAX);
        warmth = new Bound<>(STATUS_MAX, 0, STATUS_MAX);
        weariness = new Bound<>(STATUS_MAX, 0, STATUS_MAX);
        hunger = new Bound<>(STATUS_MAX, 0, STATUS_MAX);
        thirst = new Bound<>(STATUS_MAX, 0, STATUS_MAX);
        bleedingTime = 0;
    }

    public boolean isDead() {
        return getHealth() == 0;
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
        
        World.spawn(new Carcass(this.toString(), (Location) getHolder(), inventory));
        super.destroy();
    }

    @Override
    public Class<? extends Entity> getHoldCapability() {
        return Item.class;
    }

    public abstract int getDamagePerTurn();

    public int getHealth() {
        return health.getValue();
    }

    public void setHealth(int health) {
        this.health.setValue(health);
    }

    public int getWarmth() {
        return warmth.getValue();
    }

    public void setWarmth(int warmth) {
        this.warmth.setValue(warmth);
    }

    public int getWeariness() {
        return weariness.getValue();
    }

    public void setWeariness(int weariness) {
        this.weariness.setValue(weariness);
    }

    public int getHunger() {
        return hunger.getValue();
    }

    public void setHunger(int hunger) {
        this.hunger.setValue(hunger);
    }

    public Action getCurrentAction() {
        return currentAction;
    }

    public int getThirst() {
        return thirst.getValue();
    }

    public void setThirst(int thirst) {
        this.thirst.setValue(thirst);
    }

    public int getBleedingTime() {
        return bleedingTime;
    }

    public void setBleedingTime(int bleedingTime) {
        this.bleedingTime = bleedingTime;
    }

    public Tracker getInventory() {
        return inventory;
    }

    public void setAction(Action action) {
        currentAction = action;
    }

    @Override
    public void update() {

        if (currentAction != null) {
            currentAction.update();
        }
        // loop allows for zero-cost actions
        while ((currentAction == null || currentAction.isDone())) {
            decideNewAction();
            if (isDead()) {
                return;
            }
        }

        // apply room temperature and windchill
        setWarmth(getWarmth() + getCurrentLocation().getTotalTemperature());
        // TODO: temperature bonusses
        if (getWarmth() <= 0) {
            setHealth(getHealth() - 1);
        }

        // other actions increase fatigue
        setWeariness(getWeariness() - 1);
        if (getWeariness() <= 0) {
            setHealth(getHealth() - 1);
        }

        // other actions increase hunger
        setHunger(getHunger() - 1);
        if (getHunger() <= 0) {
            setHealth(getHealth() - 1);
        }

        // other actions increase thirst
        setThirst(getThirst() - 1);
        if (getThirst() <= 0) {
            setHealth(getHealth() - 1);
        }

        // bleeding away!
        if (bleedingTime > 0) {
            setHealth(getHealth() - 1);
            --bleedingTime;
            if (bleedingTime < 0) {
                bleedingTime = 0;
            }
        }

        if (getWarmth() > 0 && getWeariness() > 0 && getHunger() > 0 && getThirst() > 0 && bleedingTime == 0) {
            setHealth(getHealth() + 1);
        }

        // are you dead yet?
        if (health.eq(0)) {
            // yep
            destroy();
        }
    }

    @Override
    public Tracker getTracker() {
        return inventory;
    }

    public abstract void decideNewAction();

    @Override
    public String description() {
        String res = "";
        res += Util.capitalize(this.toString());
        if (getHealth() <= STATUS_MAX / 2) {
            res += ", blessé";
            if (getHealth() <= STATUS_MAX / 4) {
                res += " gravement";
            }
        }
        if (!(getWarmth() > 0 && getWeariness() > 0 && getHunger() > 0 && getThirst() > 0)) {
            res += ", mourrant";
        }
        if (bleedingTime > 0) {
            res += ", entrain de saigner";
        }
        return res + ".";
    }

}
