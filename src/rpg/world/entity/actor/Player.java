/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.actor;

import rpg.utils.Named;
import rpg.world.Location;

@Named(name = "joueur")
public class Player extends Human {

    public Player(Location currentLocation) {
        super("vous", currentLocation);
    }

    @Override
    public void decideNewAction() {
        // TODO
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    
}
