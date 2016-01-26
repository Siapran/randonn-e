/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.rules;

import java.util.HashMap;
import java.util.Map;
import rpg.utils.Bound;

/**
 *
 * @author siapran
 */
public class SkillManager {

    private final Map<Skill, Bound<Integer>> skills;
    
    public SkillManager() {
        skills = new HashMap<>();
    }
    
    public void set(Skill skill, int value) {
        Bound<Integer> res = skills.getOrDefault(skill, new Bound<>(0, 0, 100));
        res.setValue(value);
    }
    
    public boolean containsKey(Skill skill) {
        return skills.containsKey(skill);
    }
    
    public void increment(Skill skill) {
        Bound<Integer> res = skills.getOrDefault(skill, new Bound<>(0, 0, 100));
        res.setValue(res.getValue() + 1);
    }
    
    public int get(Skill skill) {
        Bound<Integer> res = skills.get(skill);
        if (res != null) {
            return res.getValue();
        } else {
            return 0;
        }
    }
    
}
