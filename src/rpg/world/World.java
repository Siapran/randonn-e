/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world;

import rpg.utils.Named;
import rpg.utils.Tracker;



/**
 *
 * @author siapran
 */
@Named(name = "le monde")
public class World {
    
    private final Tracker tracked;
    
    private World() {
        tracked = new Tracker();
    }
    
    public static World getInstance() {
        return WorldHolder.INSTANCE;
    }
    
    private static class WorldHolder {

        private static final World INSTANCE = new World();
    }

    public Tracker getTracked() {
        return tracked;
    }
    
    public void update() {
        tracked.stream().forEach((entity) -> {
            entity.update();
        });
    }
    
    public static void spawn(Tracked trackable) {
        // lol we don't do anything actually
        // I just needed this method to improve readability
    }
}
