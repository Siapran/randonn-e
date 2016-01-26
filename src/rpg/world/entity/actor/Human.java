/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.actor;

import rpg.rules.Skill;
import rpg.rules.SkillManager;
import rpg.utils.Named;
import rpg.world.entity.Actor;
import rpg.world.Location;
import rpg.world.World;
import rpg.world.entity.Item;
import rpg.world.entity.item.food.RawMeat;
import rpg.world.entity.item.tool.Hand;
import rpg.world.entity.item.tool.Weapon;

@Named(name = "humain")
public class Human extends Actor {

    private final String name;
    private final SkillManager skillManager;

    public Human(String name, Location currentLocation) {
        super(currentLocation);
        this.name = name;
        skillManager = new SkillManager();
        skillManager.set(Skill.FIREMAKING, 50);
    }

    public SkillManager getSkillManager() {
        return skillManager;
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

    public Weapon getBestWeapon() {
        // do we have any kind of weapon?
        if (!getInventory().filterType(Weapon.class).isEmpty()) {
            // yay
            return ((Weapon) getInventory().filterType(Weapon.class).stream()
                    .max((t1, t2) -> Integer.compare(((Weapon) t1).getDamage(), ((Weapon) t2).getDamage()))
                    .get());
        } else {
            // nay
            return Hand.getInstance();
        }
    }

    @Override
    public int getDamagePerTurn() {
        return getBestWeapon().getDamage();
    }

}
