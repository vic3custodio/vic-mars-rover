package com.vic.marsrover.service;

import com.vic.marsrover.model.*;
import com.vic.marsrover.repo.RoverRepo;
import com.vic.marsrover.util.AtomicSequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoverService {

    @Autowired
    private RoverRepo roverRepo;

    @Autowired
    private AtomicSequenceGenerator atomicSequenceGenerator;

    public Rover deployAndMoveRover(String name, String position, String instructions) {
        String newName = generateRoverName(name);
        String[] pos = position.split(",");
        Rover rover = new Rover(newName, new Position(new Coordinates(Integer.valueOf(pos[0])
                , Integer.valueOf(pos[1]))
                , Direction.get(pos[2])));
        rover.process(instructions);
        roverRepo.addRover(rover.getPosition().getCoordinates(), rover);
        System.out.println(rover);
        return rover;
    }

    private String generateRoverName(String name) {
        String newName = name;
        if (newName == null) {
            while (true) {
                newName = "rover_" + atomicSequenceGenerator.getNext();
                if(roverRepo.getRover(newName) == null) {
                    break;
                }
            }
        }
        else {
            if(roverRepo.getRover(newName) != null) {
                throw new IllegalStateException("Rover name already exists. Cannot deploy rover with the same name!!!");
            }
        }
        return newName;
    }

    public Rover moveRover(String name, String instructions) {
        Rover rover = roverRepo.getRover(name);
        if (rover == null) {
            throw new IllegalStateException("Rover name does not exists!!!");
        }
        roverRepo.removeRover(rover.getPosition().getCoordinates());
        rover.process(instructions);
        roverRepo.addRover(rover.getPosition().getCoordinates(), rover);
        System.out.println(rover);
        return rover;
    }

    public void save() {
        roverRepo.save(roverRepo.getRovers());
    }

    public RoversOnMars retrieve() {
        RoversOnMars roversOnMars = roverRepo.retrieve();
        roverRepo.setRovers(roversOnMars.getRovers());
        return roversOnMars;
    }

}
