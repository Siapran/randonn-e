/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.utils;

import java.util.Map;
import rpg.world.entity.Item;
import rpg.world.entity.item.Tool;

/**
 *
 * @author siapran
 */
public interface Craftable {
    public Map<Class<? extends Item>, Integer> getCraftingIngredients();
    public Map<Class<? extends Tool>, Float> getCraftingToolEfficiency();
}
