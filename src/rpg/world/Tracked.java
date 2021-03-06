/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world;

import rpg.utils.Named;

/**
 *
 * @author siapran
 */
@Named(name = "connu")
public abstract class Tracked {

    @SuppressWarnings("LeakingThisInConstructor")
    public Tracked() {
        World.getInstance().getTracked().add(this); // register self to World
    }

    @Override
    public abstract String toString();

    public abstract void update(); // updates self for a turn (1 minute)

    public void destroy() {
        World.getInstance().getTracked().remove(this); // unregister self from World
    }
    
    public abstract String description();

}
