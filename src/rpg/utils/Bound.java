/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.utils;

import java.util.Objects;

/**
 *
 * @author siapran
 * @param <T>
 */
public class Bound<T extends Comparable> implements Comparable<T> {

    private T value;
    private T min;
    private T max;

    public Bound(T value, T min, T max) {
        this.value = value;
        this.min = min;
        this.max = max;
        checkBounds();
        updateValue();
    }

    public T getValue() {
        return value;
    }

    public T getMin() {
        return min;
    }

    public T getMax() {
        return max;
    }

    private void updateValue() {
        if (value.compareTo(max) == 1) {
            value = max;
        }
        if (value.compareTo(min) == -1) {
            value = min;
        }
    }

    private void checkBounds() {
        assert (min.compareTo(max) <= 0);
    }

    public void setValue(T value) {
        this.value = value;
        updateValue();
    }

    public void setMin(T min) {
        this.min = min;
        checkBounds();
        updateValue();
    }

    public void setMax(T max) {
        this.max = max;
        checkBounds();
        updateValue();
    }

    public boolean eq(T t) {
        return value.compareTo(t) == 0;
    }

    public boolean lt(T t) {
        return value.compareTo(t) == -1;
    }

    public boolean gt(T t) {
        return value.compareTo(t) == 1;
    }

    public boolean lte(T t) {
        return value.compareTo(t) <= 0;
    }

    public boolean gte(T t) {
        return value.compareTo(t) >= 0;
    }

    @Override
    public int compareTo(T t) {
        return value.compareTo(t);
    }

}
