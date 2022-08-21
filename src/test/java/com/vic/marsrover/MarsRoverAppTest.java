package com.vic.marsrover;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MarsRoverAppTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void deployAndMoveUnnamedRoverTest1() {
        String[] args = new String[2];
        args[0] = "3,4,N";
        args[1] = "f,f,r,f,f";
        MarsRoverApp.main(args);
    }

    @Test
    void deployAndMoveUnnamedRoverTest2() {
        String[] args = new String[2];
        args[0] = "3,4,N";
        args[1] = "f,f,r,f,f";
        MarsRoverApp.main(args);
    }

    @Test
    void deployAndMoveNamedRoverTest1() {
        String[] args = new String[3];
        args[0] = "rover_2";
        args[1] = "3,4,N";
        args[2] = "f,f,r,f,f";
        MarsRoverApp.main(args);
    }

    @Test
    void deployAndMoveNamedRoverTest2() {
        String[] args = new String[3];
        args[0] = "rover_3";
        args[1] = "3,4,N";
        args[2] = "f,f,r,f,f";
        MarsRoverApp.main(args);
    }

    @Test
    void deployAndMoveNamedRoverTest3() {
        String[] args = new String[3];
        args[0] = "rover_4";
        args[1] = "3,4,N";
        args[2] = "b,b,r,b,b";
        MarsRoverApp.main(args);
    }

    @Test
    void moveRoverTest() {
        String[] args = new String[2];
        args[0] = "rover_1";
        args[1] = "f,f,r,f,f";
        MarsRoverApp.main(args);
    }

}