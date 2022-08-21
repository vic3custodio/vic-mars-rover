package com.vic.marsrover.model;

import com.vic.marsrover.repo.RoverRepo;

import java.io.Serializable;
import java.util.Arrays;

public class Rover implements Serializable {

    private String name;
    private Position position;

    public Rover(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void process(String instructions) {
        Arrays.stream(instructions.split(",")).filter(instruction -> {
                    try {
                        processEachInstruction(instruction);
                        return false;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        return true;
                    }
                }
        ).findFirst();
    }

    private void processEachInstruction(String instruction) {
        switch (instruction) {
            case "r":
                turnRight();
                break;
            case "l":
                turnLeft();
                break;
            case "f":
                moveForward();
                break;
            case "b":
                moveBackward();
                break;
        }
    }

    private void moveForward() {
        Position nextPosition = new Position(new Coordinates(position.getCoordinates().getX(), position.getCoordinates().getY()), position.getDirection());
        if (RoverRepo.isValidMove(nextPosition.moveForward().getCoordinates())) {
            position = position.moveForward();
        }
        else {
            throw new IllegalStateException("Rover is about to collide. It will stay in its current position!!!");
        }
    }

    private void moveBackward() {
        Position nextPosition = new Position(new Coordinates(position.getCoordinates().getX(), position.getCoordinates().getY()), position.getDirection());
        if (RoverRepo.isValidMove(nextPosition.moveBackward().getCoordinates())) {
            position = position.moveBackward();
        }
        else {
            throw new IllegalStateException("Rover is about to collide. It will stay in its current position!!!");
        }
    }

    private void turnLeft() {
        position = position.rotateLeft();
    }

    private void turnRight() {
        position = position.rotateRight();
    }

    @Override
    public String toString() {
        return "Rover Name: " + name + "\n" + position.toString();
    }
}
