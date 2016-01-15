/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world;

/**
 *
 * @author siapran
 */
public abstract class Trackable {

    @SuppressWarnings("LeakingThisInConstructor")
    public Trackable() {
        World.getInstance().getTracked().add(this); // register self to World
    }

    @Override
    public abstract String toString();

    public abstract void update(); // updates self for a turn (1 minute)

    public void destroy() {
        World.getInstance().getTracked().remove(this); // unregister self from World
    }

}
