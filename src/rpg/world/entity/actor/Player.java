/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.actor;

import rpg.world.Location;


public class Player extends Human {

    public Player(Location currentLocation) {
        super("Vous", currentLocation);
    }
    
}
