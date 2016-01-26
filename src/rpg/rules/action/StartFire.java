/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.rules.action;

import rpg.rules.Action;
import rpg.rules.Skill;
import rpg.utils.Util;
import rpg.world.entity.Actor;
import rpg.world.entity.actor.Human;
import rpg.world.entity.actor.Player;
import rpg.world.entity.container.Fire;
import rpg.world.entity.item.Fuel;

public class StartFire extends Action {

    private final Fuel fuel;

    public StartFire(Fuel fuel, Human actor) {
        super(actor);
        this.fuel = fuel;
        postConstructionInit();

    }

    @Override
    public void update() {
        --timeleft;
        if (timeleft <= 0) {
            Actor actor = getActor();
            Human human = (Human) actor;

            int success_chance = human.getSkillManager().get(Skill.FIREMAKING);
            success_chance += fuel.getFlamability();
            success_chance += actor.getCurrentLocation().getWind();
            success_chance /= 2;

            if (Util.rand(success_chance)) {
                // create the fire
                Fire fire = new Fire(0, actor.getCurrentLocation());
                fire.addFuel(fuel);

                // increment skill
                human.getSkillManager().increment(Skill.HUNTING);
                Util.AlertPlayer(actor, "Vous avez allumé un feu.");
            } else {
                Util.AlertPlayer(actor, "Vous n'avez pas réussi à maintenir une flamme assez longtemps...");
            }
        }
    }


    @Override
    public int getCost() {
        return 5;
    }

}
