/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.rules.action;

import rpg.rules.Action;
import rpg.utils.Named;
import rpg.utils.Util;
import rpg.world.entity.Actor;
import rpg.world.entity.actor.Human;

@Named(name = "se défendre")
public class Defend extends Action {

    private final Actor attacker;

    public Defend(Actor attacker, Actor actor) {
        super(actor);
        this.attacker = attacker;
        if (actor instanceof Human) {
            Human human = (Human) actor;
            Util.AlertPlayer(human, "Vous vous défendez avec " + human.getBestWeapon() + ".");
        }
    }

    @Override
    public void update() {
        --timeleft;
        if (attacker.isDead() || getActor().isDead()) {
            timeleft = 0; // end fight
        }
        attacker.setBleedingTime(attacker.getBleedingTime() + getActor().getDamagePerTurn());
    }

    @Override
    public int getCost() {
        return 1;
    }

}
