/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.rules.action;

import java.util.logging.Level;
import java.util.logging.Logger;
import rpg.rules.Action;
import rpg.utils.Cookable;
import rpg.utils.InsufficientHoldCapability;
import rpg.utils.Named;
import rpg.world.entity.Actor;
import rpg.world.entity.Item;
import rpg.world.entity.actor.Player;
import rpg.world.entity.container.Fire;

@Named(name = "cuire")
public class Cook extends Action {

    private final Cookable cookable;
    private final Fire fire;

    public Cook(Cookable cookable, Fire fire, Actor actor) {
        super(actor);
        this.cookable = cookable;
        this.fire = fire;
        if (actor instanceof Player) {
            Player player = (Player) actor;
            System.out.println("Vous faîtes cuire: " + cookable);
        }
    }

    @Override
    public void update() {
        --timeleft;
        if (fire.getDuration() == 0) {
            timeleft = 0;
            if (getActor() instanceof Player) {
                Player player = (Player) getActor();
                System.out.println("Le feu s'est éteint avant la fin de la cuisson...");
            }
            return; // too bad
        }
        if (timeleft <= 0) {
            try {
                ((Item) cookable).moveTo(getActor());
            } catch (InsufficientHoldCapability ex) {
                Logger.getLogger(Cook.class.getName()).log(Level.SEVERE, null, ex);
            }
            cookable.replaceWithCookedProduct();
        }
    }

    @Override
    public int getCost() {
        return 10;
    }

}
