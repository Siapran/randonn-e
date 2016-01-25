/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.rules.action;

import rpg.rules.Action;
import rpg.utils.Named;
import rpg.world.entity.Actor;
import rpg.world.entity.actor.Player;

@Named(name = "se défendre")
public class Defend extends Action {

    private final Actor attacker;

    public Defend(Actor attacker, Actor actor) {
        super(actor);
        this.attacker = attacker;
        if (actor instanceof Player) {
            Player player = (Player) actor;
            System.out.println("Un " + attacker + " vous attaque!");
            System.out.println("Vous vous défendez avec " + player.getBestWeapon() + ".");
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
