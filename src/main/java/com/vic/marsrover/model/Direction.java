package com.vic.marsrover.model;

import java.io.Serializable;

public enum Direction implements Serializable {

    NORTH("N") {
        @Override
        public Direction left(){
            return WEST;
        }

        @Override
        public Direction right(){
            return EAST;
        }
    },

    SOUTH("S") {
        @Override
        public Direction left(){
            return EAST;
        }

        @Override
        public Direction right(){
            return WEST;
        }
    },

    EAST("E") {
        @Override
        public Direction left(){
            return NORTH;
        }

        @Override
        public Direction right(){
            return SOUTH;
        }
    },

    WEST("W") {
        @Override
        public Direction left(){
            return SOUTH;
        }

        @Override
        public Direction right(){
            return NORTH;
        }
    };


    private String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public abstract Direction left();

    public abstract Direction right();

    public static Direction get(String directionSign) {
        switch (directionSign) {
            case "N":
                return NORTH;
            case "S":
                return SOUTH;
            case "E":
                return EAST;
            case "W":
                return WEST;
            default:
                throw new IllegalStateException("Unknown Direction Code!!!");
        }
    }

}
