package com.vic.marsrover.model;


import java.io.Serializable;

public class Position implements Serializable {
    private Coordinates coordinates;
    private Direction direction;

    public Position(Coordinates coordinates, Direction direction) {
        this.coordinates = coordinates;
        this.direction = direction;
    }

    public Position rotateRight() {
        return new Position(coordinates, direction.right());
    }

    public Position rotateLeft() {
        return new Position(coordinates, direction.left());
    }

    public Position moveForward() {
        switch (direction.toString()) {
            case "EAST":
                coordinates.setX(coordinates.getX()+1);
                break;
            case "WEST":
                coordinates.setX(coordinates.getX()-1);
                break;
            case "NORTH":
                coordinates.setY(coordinates.getY()+1);
                break;
            case "SOUTH":
                coordinates.setY(coordinates.getY()-1);
                break;
            default:
                throw new IllegalStateException("Unknown Direction!!!");
        }

        return new Position(coordinates, direction);
    }

    public Position moveBackward() {
        switch (direction.toString()) {
            case "EAST":
                coordinates.setX(coordinates.getX()-1);
                break;
            case "WEST":
                coordinates.setX(coordinates.getX()+1);
                break;
            case "NORTH":
                coordinates.setY(coordinates.getY()-1);
                break;
            case "SOUTH":
                coordinates.setY(coordinates.getY()+1);
                break;
            default:
                throw new IllegalStateException("Unknown Direction!!!");
        }
        return new Position(coordinates, direction);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        String str1 = "Final Coordinates: " + coordinates.getX() + " " + coordinates.getY();
        String str2 = "Final Direction: " + direction;
        return str1 + "\n" + str2;
    }
}
