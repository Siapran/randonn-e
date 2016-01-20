/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world;

import rpg.utils.Holder;
import rpg.utils.Named;
import rpg.utils.Tracker;

@Named(name = "lieu")
public abstract class Location extends Tracked implements Holder {

    private final String name;
    private final Tracker edges;
    private final Tracker contents;
    private int temperature;
    private int wind;

    public Location(String name, Tracker edges, int temperature, int windchill) {
        this.name = name;
        this.edges = edges;
        contents = new Tracker();
        this.temperature = temperature;
        this.wind = windchill;
    }

    public int getTemperature() {
        return temperature;
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
}
