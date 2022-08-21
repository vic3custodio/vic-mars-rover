package com.vic.marsrover.service;

import com.vic.marsrover.model.Rover;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class RoverServiceTest {

    @Autowired
    private RoverService roverService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void deployAndMoveRover() {
        Rover rover = roverService.deployAndMoveRover(null, "3,4,N", "f,f,r,f,f");
        Assert.assertNotNull(rover);
    }

    @Test
    void moveRover() {
        Rover rover = roverService.moveRover("rover_1", "b,f,r,f,b");
        Assert.assertNotNull(rover);
    }

}