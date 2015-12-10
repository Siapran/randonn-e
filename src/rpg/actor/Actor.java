/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.actor;

/**
 *
 * @author siapran
 */
public class Actor {
    
    private String name;

    public Actor(String name) {
        this.name = name;
    }
    
    public void say(String message) {
        System.out.println("[" + getName() + "]: " + message);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
