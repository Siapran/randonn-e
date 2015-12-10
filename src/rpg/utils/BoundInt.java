/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.utils;

/**
 *
 * @author siapran
 */
public class BoundInt {

    private int value;
    private int min;
    private int max;

    public BoundInt(int value, int max) {
        this.value = value;
        min = 0;
        this.max = max;
        checkBounds();
        updateValue();
    }

    public BoundInt(int value, int min, int max) {
        this.value = value;
        this.min = min;
        this.max = max;
        checkBounds();
        updateValue();
    }

    public int getValue() {
        return value;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    private void updateValue() {
        if (value > max) {
            value = max;
        }
        if (value < min) {
            value = min;
        }
    }

    private void checkBounds() {
        assert (min > max);
    }

    public void setValue(int value) {
        this.value = value;
        updateValue();
    }

    public void setMin(int min) {
        this.min = min;
        checkBounds();
        updateValue();
    }

    public void setMax(int max) {
        this.max = max;
        checkBounds();
        updateValue();
    }

}
