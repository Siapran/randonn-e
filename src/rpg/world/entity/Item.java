/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity;

import rpg.utils.Bound;
import rpg.utils.Holder;
import rpg.utils.Named;
import rpg.utils.Util;
import rpg.world.Entity;

@Named(name = "objet")
public abstract class Item extends Entity {

    public static final int CONDITION_MAX = 10000;

    protected Bound<Integer> condition;
    protected int weight;

    public Item(Holder holder, int condition, int weight) {
        super(holder);
        this.condition = new Bound(condition, 0, CONDITION_MAX);
        this.weight = weight;
    }

    @Override
    public void update() {
        if (condition.lte(0)) {
            destroy();
        }
    }

    public void setCondition(int condition) {
        this.condition.setValue(condition);
    }

    public int getCondition() {
        return condition.getValue();
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String description() {
        String res = "";
        res += Util.capitalize(this.toString());
        if (getCondition() <= CONDITION_MAX / 3) {
            res += ", en mauvais état";
        }
        res += ", pesant " + getWeight() + "g";
        return res + ".";
    }

}
