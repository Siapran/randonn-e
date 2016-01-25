/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world;

import java.util.Iterator;
import rpg.utils.Holder;
import rpg.utils.Named;
import rpg.utils.Tracker;
import rpg.world.entity.container.Fire;

@Named(name = "lieu")
public abstract class Location extends Tracked implements Holder {

    private final String name;
    private final Tracker edges;
    private final Tracker contents;
    private int temperature;
    private int wind;

    public Location(String name, int temperature, int windchill) {
        this.name = name;
        this.edges = new Tracker();
        contents = new Tracker();
        this.temperature = temperature;
        this.wind = windchill;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getTotalTemperature() {
        int total = temperature + wind;
        total += getTracker().filterType(Fire.class).stream().count() * 20;
        return total;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getWind() {
        return wind;
    }

    public void setWind(int wind) {
        this.wind = wind;
    }

    @Override
    public Tracker getTracker() {
        return contents;
    }

    @Override
    public Class<? extends Entity> getHoldCapability() {
        return Entity.class;
    }

    public Tracker getEdges() {
        return edges;
    }

    @Override
    public String toString() {
        return name;
    }

    public void addEdge(Location location) {
        this.getEdges().add(location);
        location.getEdges().add(this);
    }

    public abstract void init();

    @Override
    public void update() {

    }

    @Override
    public String description() {
        String res = name;
        res += "\ntempérature: " + getTemperature();
        res += "\nfacteur vent: " + getWind();
        if (!getTracker().isEmpty()) {
            res += "\ncontient:";
            for (Iterator<Tracked> iterator = contents.iterator(); iterator.hasNext();) {
                Tracked tracked = (Tracked) iterator.next();
                res += " " + tracked;
                if (iterator.hasNext()) {
                    res += ",";
                } else {
                    res += ".";
                }
            }
        }
        if (!getEdges().isEmpty()) {
            res += "\nmène à:";
            for (Iterator<Tracked> iterator = edges.iterator(); iterator.hasNext();) {
                Location location = (Location) iterator.next();
                res += " " + location;
                if (iterator.hasNext()) {
                    res += ",";
                } else {
                    res += ".";
                }
            }
        }
        return res;
    }

}
