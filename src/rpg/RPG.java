/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import rpg.world.World;
import rpg.world.entity.actor.Player;

/**
 *
 * @author siapran
 */
public class RPG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        World world = World.getInstance();
        
        System.out.println("Vous êtes perdus dans la campagne canadienne en plein hiver."
                + " Tentez de survivre le plus longtemps possible!");
        
        world.init();
        
        while (!world.getTracked().filterType(Player.class).isEmpty()) {            
            world.update();
        }
        
        System.out.println("Vous avez survécu " + world.getTicks() + " minutes.");
    }
    
}
