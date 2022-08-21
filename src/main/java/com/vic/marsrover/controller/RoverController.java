package com.vic.marsrover.controller;

import com.vic.marsrover.model.Rover;
import com.vic.marsrover.service.RoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoverController {

    @Autowired
    private RoverService roverService;

    @GetMapping("/deployAndMoveRover/position/{position}/instructions/{instructions}")
    Rover deployAndMoveRover(@PathVariable String position, @PathVariable String instructions) {
        return deployAndMoveRover(null, position, instructions);
    }

    @GetMapping("/deployAndMoveRover/name/{name}/position/{position}/instructions/{instructions}")
    Rover deployAndMoveRover(@PathVariable String name, @PathVariable String position, @PathVariable String instructions) {
        roverService.retrieve();
        Rover rover = roverService.deployAndMoveRover(name, position, instructions);
        roverService.save();
        return rover;
    }

    @GetMapping("/moveRover/name/{name}/instructions/{instructions}")
    Rover moveRover(@PathVariable String name, @PathVariable String instructions) {
        roverService.retrieve();
        Rover rover = roverService.moveRover(name, instructions);
        roverService.save();
        return rover;
    }

    @ExceptionHandler({IllegalStateException.class})
    public String handleException(IllegalStateException e) {
        return "Error: " + e.getMessage();
    }

}
