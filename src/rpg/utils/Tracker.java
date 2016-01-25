/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.utils;

import java.util.Collection;
import java.util.HashSet;
import rpg.world.Tracked;

/**
 *
 * @author siapran
 */
public class Tracker extends HashSet<Tracked> {

    public Tracker() {
    }

    public Tracker(Collection<? extends Tracked> clctn) {
        super(clctn);
    }

    public Tracker filterType(Class<? extends Tracked> type) {
        Tracker res = new Tracker();
        stream().filter((entity) -> (type.isInstance(entity))).forEach((entity) -> {
            res.add(type.cast(entity));
        });
        return res;
    }
}
