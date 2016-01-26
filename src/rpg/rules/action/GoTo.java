/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.rules.action;

import rpg.rules.Action;
import rpg.utils.InsufficientHoldCapability;
import rpg.utils.Named;
import rpg.utils.Util;
import rpg.world.entity.Actor;
import rpg.world.Location;
import rpg.world.entity.actor.Player;

@Named(name = "aller à")
public class GoTo extends Action {

    private final Location location;

    public GoTo(Location location, Actor actor) {
        super(actor);
        this.location = location;
        postConstructionInit();
    }

    public void doEffect() {
        try {
            getActor().moveTo(location);
            Util.AlertPlayer(getActor(), "Vous allez vers " + location + ".");
        } catch (InsufficientHoldCapability ex) {
            // never reached
        }
    }

    @Override
    public int getCost() {
        return 5; // TODO: implement distance?
        // TODO: implement encumbrance
    }

    @Override
    public void update() {
        --timeleft;
        if (timeleft <= 0) {
            doEffect();
        }
    }

}
