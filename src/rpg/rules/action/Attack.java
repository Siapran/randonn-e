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

@Named(name = "attaquer")
public class Attack extends Action {

    private final Actor target;

    public Attack(Actor target, Actor actor) {
        super(actor);
        this.target = target;
        postConstructionInit();
        Util.AlertPlayer(target, "Un " + actor + " vous attaque!");
        target.setAction(new Defend(getActor(), target));
    }

    @Override
    public void update() {
        --timeleft;
        if (target.isDead() || getActor().isDead()) {
            timeleft = 0; // end fight
        }
        target.setBleedingTime(target.getBleedingTime() + getActor().getDamagePerTurn());
    }

    @Override
    public int getCost() {
        return 1;
    }

}
