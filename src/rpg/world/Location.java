/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world;

import rpg.utils.Holder;
import rpg.utils.Tracker;

public abstract class Location extends Trackable implements Holder {

    private final String name;
    private final Tracker edges;
    private final Tracker contents;
    private double temperature;
    private double wind;

    public Location(String name, Tracker edges, double temperature, double windchill) {
        this.name = name;
        this.edges = edges;
        contents = new Tracker();
        this.temperature = temperature;
        this.wind = windchill;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWind() {
        return wind;
    }

    public void setWind(double wind) {
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

}
