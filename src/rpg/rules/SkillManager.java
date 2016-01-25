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

    public boolean containsKey(Skill skill) {
        return skills.containsKey(skill);
    }
    
    public void increment(Skill skill) {
        
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
