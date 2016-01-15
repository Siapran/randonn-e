/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.utils;

import java.util.HashSet;
import rpg.world.Trackable;

/**
 *
 * @author siapran
 * @param <T>
 */
public class Tracker extends HashSet<Trackable> {
    
    public Tracker filterType(Class<? extends Trackable> type) {
        Tracker res = new Tracker();
        stream().filter((entity) -> (type.isInstance(entity))).forEach((entity) -> {
            res.add(type.cast(entity));
        });
        return res;
    }
}
