/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.location;

import rpg.utils.Named;

@Named(name = "maison")
public class House extends IndoorLocation {

    public House(String name) {
        super(name);
    }
    @Override
    public void init() {
        
    }
    
}
