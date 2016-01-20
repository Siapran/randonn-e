/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.actor;

import java.util.Optional;
import rpg.rules.action.Attack;
import rpg.rules.action.Consume;
import rpg.rules.action.GoTo;
import rpg.utils.Named;
import rpg.utils.Tracker;
import rpg.world.Location;
import rpg.world.Tracked;
import rpg.world.World;
import rpg.world.entity.Actor;
import static rpg.world.entity.Actor.STATUS_MAX;
import rpg.world.entity.Container;
import rpg.world.entity.Item;
import rpg.world.entity.container.Corpse;
import rpg.world.entity.item.Food;
import rpg.world.entity.item.food.RawMeat;
import rpg.world.location.OutdoorLocation;

@Named(name = "loup")
public class Wolf extends Animal {

    public Wolf(Location currentLocation) {
        super(currentLocation);
    }

    @Override
    public int getFurWarmthBonus() {
        return 20;
    }

    @Override
    public int getDamagePerTurn() {
        return 100;
    }

    @Override
    public String toString() {
        return "loup";
    }

    @Override
    public void decideNewAction() {
        
        // are we in imminent danger?
        if (getBleedingTime() >= (STATUS_MAX - getHealth()) / 2) {
            // fuckfuckfuckfuckfuck
            Optional<Tracked> destination = getCurrentLocation().getEdges()
                    .filterType(OutdoorLocation.class).stream().findAny();
            if (destination.isPresent()) {
                // I'm outta here
                setAction(new GoTo((Location) destination.get(), this));
                return;
            }
        }

        // attack potential prey
        Tracker actors = getCurrentLocation().getTracker().filterType(Actor.class);
        // kill all humans
        Optional<Tracked> target = actors.filterType(Human.class).stream().findAny();
        if (!target.isPresent()) {
            // find any other pray
            target = actors.filterType(Animal.class).stream()
                    // yeah let's not attack each other
                    .filter((actor) -> !(actor instanceof Wolf))
                    // find the weakest
                    .min((a1, a2) -> Integer.compare(((Actor) a1).getHealth(), ((Actor) a2).getHealth()));
        }
        if (target.isPresent()) {
            // found dinner
            setAction(new Attack((Actor) target.get(), this));
            return;
        }

        // look for raw meat in local corpses
        Tracker containers = getCurrentLocation().getTracker().filterType(Corpse.class);
        for (Tracked tracked : containers) {
            Container container = (Container) tracked;
            target = container.getTracker().filterType(RawMeat.class).stream().findAny();
            if (target.isPresent()) {
                // eat directly from container
                setAction(new Consume((Food) target.get(), this));
                return;
            }
        }

        super.decideNewAction(); // do normal stuff like sleeping

        if (getCurrentAction() == null) {
            // "smell" out other actors in adjacent locations
            Optional<Tracked> destination = getCurrentLocation().getEdges()
                    .filterType(OutdoorLocation.class).stream()
                    .filter((location)
                            -> !((Location) location).getTracker().filterType(Actor.class).isEmpty()
                    ).findAny();
            if (destination.isPresent()) {
                setAction(new GoTo((Location) destination.get(), this));
            }
        }
    }

    @Override
    public void destroy() {
        World.spawn(new RawMeat(this, Item.CONDITION_MAX, getHunger() + STATUS_MAX));
        super.destroy();
    }

}
