/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.utils;

import java.util.Random;
import rpg.world.entity.Actor;
import rpg.world.entity.actor.Player;

/**
 *
 * @author siapran
 */
public class Util {

    public static String capitalize(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    private static final Random generator = new Random();

    public static boolean rand(int probabiblity) {
        return generator.nextInt(100) < probabiblity;
    }

    public static Random getGenerator() {
        return generator;
    }

    public static void AlertPlayer(Actor actor, String message) {
        if (actor instanceof Player) {
            Player player = (Player) actor;
            System.out.println(message);
        }
    }
    
    
}
