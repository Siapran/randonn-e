/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world;

import rpg.utils.Named;
import rpg.utils.Tracker;
import rpg.utils.Util;
import rpg.world.entity.Item;
import rpg.world.entity.actor.Player;
import rpg.world.entity.actor.Wolf;
import rpg.world.entity.container.Carcass;
import rpg.world.entity.container.Cupboard;
import rpg.world.entity.item.food.CannedBeans;
import rpg.world.entity.item.food.CerealBar;
import rpg.world.entity.item.fuel.FireLog;
import rpg.world.entity.item.tool.CanOpener;
import rpg.world.entity.item.tool.Knife;
import rpg.world.location.Forest;
import rpg.world.location.House;
import rpg.world.location.Lake;

/**
 *
 * @author siapran
 */
@Named(name = "le monde")
public class World {

    private final Tracker tracked;
    private int outdoorTemperature = 0;
    private int wind = 0;
    private long ticks = 0;

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
        Tracker workingCopy = new Tracker(tracked);
        workingCopy.stream().forEach((entity) -> {
            entity.update();
        });
        ++ticks;
        outdoorTemperature = (int) (5 * Math.sin(ticks / 20) + 5 * Math.sin(ticks / 60) - 10);
        wind = (int) (2 * Math.sin(ticks / 2) + 3 * Math.sin(ticks / 6) - 5);
    }
    // (5 * sin(x/20) + 5 * sin (x/60)

    public int getOutdoorTemperature() {
        return outdoorTemperature;
    }

    public int getWind() {
        return wind;
    }

    public long getTicks() {
        return ticks;
    }

    public static void spawn(Tracked trackable) {
        // lol we don't do anything actually
        // I just needed this method to improve readability (and suppress warnings)
    }

    public void init() {
        // a clearing with a dead wolf
        Location forest = new Forest("clairière");
        Wolf wolf = new Wolf(forest);
        wolf.destroy();

        // a cabin with a cupboard
        House house = new House("cabane");
        Cupboard cupboard = new Cupboard(house);
        spawn(new CerealBar(cupboard, Item.CONDITION_MAX - Util.getGenerator().nextInt(25)));
        spawn(new CannedBeans(cupboard, Item.CONDITION_MAX - Util.getGenerator().nextInt(25)));
        spawn(new CanOpener(cupboard, Item.CONDITION_MAX - Util.getGenerator().nextInt(25)));
        spawn(new Knife(house, Item.CONDITION_MAX - Util.getGenerator().nextInt(25)));
        spawn(new FireLog(house));
        forest.addEdge(house);

        // a frozen lake
        Location lake = new Lake("lac");
        forest.addEdge(lake);

        // a deep forest with a wolf
        Location blackForest = new Forest("forêt");
        spawn(new Wolf(blackForest));
        lake.addEdge(blackForest);

        tracked.filterType(Location.class).forEach((location) -> ((Location) location).init());
        
        spawn(new Player(forest));
    }
}
