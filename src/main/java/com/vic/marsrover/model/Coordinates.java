package com.vic.marsrover.model;

import java.io.Serializable;
import java.util.Objects;

public class Coordinates implements Serializable {

    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinates)) return false;
        Coordinates grid = (Coordinates) o;
        return x == grid.x &&
                y == grid.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }
}
