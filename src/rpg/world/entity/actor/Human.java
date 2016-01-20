/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.actor;

import rpg.utils.Named;
import rpg.world.entity.Actor;
import rpg.world.Location;
import rpg.world.World;
import rpg.world.entity.Item;
import rpg.world.entity.item.food.RawMeat;
import rpg.world.entity.item.tool.Weapon;

@Named(name = "humain")
public class Human extends Actor {

    private final String name;

    public Human(String name, Location currentLocation) {
        super(currentLocation);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void destroy() {
        World.spawn(new RawMeat(this, Item.CONDITION_MAX, getHunger() + STATUS_MAX));
        super.destroy();
    }

    @Override
    public void decideNewAction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getDamagePerTurn() {
        if (!getInventory().filterType(Weapon.class).isEmpty()) {
            return ((Weapon) getInventory().filterType(Weapon.class).stream()
                    .max((t1, t2) -> Integer.compare(((Weapon) t1).getDamage(), ((Weapon) t2).getDamage()))
                    .get()).getDamage();
        } else {
            return 50;
        }
    }

}
