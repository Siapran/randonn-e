/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.utils;

import rpg.world.Entity;

/**
 *
 * @author siapran
 */
public interface Holder {
    public Class<? extends Entity> getHoldCapability();
    public Tracker getTracker();
}
