/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.rules.action;

import rpg.rules.Action;
import rpg.world.entity.Actor;
import rpg.world.entity.actor.Player;
import rpg.world.entity.container.Fire;
import rpg.world.entity.item.Fuel;

public class StartFire extends Action {

    private final Fuel fuel;

    public StartFire(Fuel fuel, Actor actor) {
        super(actor);
        this.fuel = fuel;
        postConstructionInit();

    }

    @Override
    public void update() {
        --timeleft;
        if (timeleft <= 0) {
            Fire fire = new Fire(0, getActor().getCurrentLocation());
            fire.addFuel(fuel);
            if (getActor() instanceof Player) {
                Player player = (Player) getActor();
                System.out.println("Vous avez allumé un feu.");
            }
        }
    }

    @Override
    public int getCost() {
        return 5;
    }

}
