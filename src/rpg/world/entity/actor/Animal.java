/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.actor;

import rpg.rules.action.Sleep;
import rpg.utils.Named;
import rpg.world.entity.Actor;
import rpg.world.Location;

/**
 *
 * @author siapran
 */
@Named(name = "animal")
public abstract class Animal extends Actor {

    public Animal(Location currentLocation) {
        super(currentLocation);
    }

    @Override
    public void update() {
        setWarmth(getWarmth() + getFurWarmthBonus()); // animals have fur to protect them from cold
        setThirst(getThirst() + 2); // animals do not suffer from thirst
                                    // TODO: implement pathfinding to find water source
        super.update();
    }
    
    public abstract int getFurWarmthBonus();

    @Override
    public void decideNewAction() {
        if (getWeariness() <= STATUS_MAX / 4) {
            setAction(new Sleep(15, this)); // sleep and wakeup every 15 minutes
        }
    }
    
    
    
}
