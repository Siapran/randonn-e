/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.item.food;

import rpg.world.entity.item.food.Canned;
import rpg.utils.Holder;
import rpg.utils.Named;

@Named(name = "haricots en boîte")
public class CannedBeans extends Canned {

    public CannedBeans(Holder holder, int condition) {
        super(400, holder, condition, 500);
    }

    @Override
    public String toString() {
        return "haricots en boîte";
    }
    
}
