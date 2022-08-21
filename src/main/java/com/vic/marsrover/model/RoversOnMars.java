package com.vic.marsrover.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RoversOnMars implements Serializable {

    private Map<Coordinates, Rover> rovers = new HashMap<>();

    public RoversOnMars(Map<Coordinates, Rover> rovers) {
        this.rovers = rovers;
    }

    public Map<Coordinates, Rover> getRovers() {
        return rovers;
    }

}
