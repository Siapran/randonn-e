/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.rules;

/**
 *
 * @author siapran
 */
public enum Skill {

    
    HUNTING("Chasser", GoTo.class),
    CRAFTING("Bricoler", GoTo.class),
    FIREMAKING("Allumer un feu.", GoTo.class);

    private final String name;
    private final Class<? extends Action> action;

    private Skill(String name, Class<? extends Action> action) {
        this.name = name;
        this.action = action;
    }

    @Override
    public String toString() {
        return name;
    }

}
