/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world;

import java.util.logging.Level;
import java.util.logging.Logger;
import rpg.utils.Holder;
import rpg.utils.InsufficientHoldCapability;
import rpg.utils.Named;

@Named(name = "entité")
public abstract class Entity extends Tracked {

    private Holder holder;

    public Entity(Holder holder) {
        super();
        try {
            moveTo(holder);
        } catch (InsufficientHoldCapability ex) {
            // should not be reached
            // workaround for type erasure
            Logger.getLogger(Entity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public final void moveTo(Holder holder) throws InsufficientHoldCapability {
        if (holder != null && !holder.getHoldCapability().isAssignableFrom(this.getClass())) {
            throw new InsufficientHoldCapability();
        }
        if (this.holder != null) {
            this.holder.getTracker().remove(this);
        }
        this.holder = holder;
        if (this.holder != null) {
            this.holder.getTracker().add(this);
        }
    }

    public Holder getHolder() {
        return holder;
    }

    @Override
    public void destroy() {

        try {
            moveTo(null); // remove self from holder
        } catch (InsufficientHoldCapability ex) {
            Logger.getLogger(Entity.class.getName()).log(Level.SEVERE, null, ex);
        }

        super.destroy();
    }

}
