/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.location;

import rpg.utils.Named;
import rpg.utils.Tracker;

@Named(name = "forêt")
public class Forest extends OutdoorLocation {

    public Forest(String name, Tracker edges, int temperature, int windchill) {
        super(name, edges, temperature, windchill);
    }

    @Override
    public void init() {
        
    }

    @Override
    public void update() {
        
    }
    
    
    
}
