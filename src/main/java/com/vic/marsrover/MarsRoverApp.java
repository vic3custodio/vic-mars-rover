package com.vic.marsrover;

import com.vic.marsrover.service.RoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MarsRoverApp implements CommandLineRunner {

    @Autowired
    private RoverService roverService;

    public static void main(String[] args) {
        SpringApplicationBuilder app = new SpringApplicationBuilder(MarsRoverApp.class);
        if (args.length == 0) {
            app.web(WebApplicationType.SERVLET); // use as a web app
        } else {
            app.web(WebApplicationType.NONE); // use as CLI app
        }
        app.run(args);
    }

    @Override
    public void run(String... args) {
        try {
            roverService.retrieve();
            if (args.length == 3) {
                roverService.deployAndMoveRover(args[0], args[1], args[2]);
            }
            else if (args.length == 2 && args[0].split(",").length == 3) {
                roverService.deployAndMoveRover(null, args[0], args[1]);
            }
            else if (args.length == 2) {
                roverService.moveRover(args[0], args[1]);
            }
            roverService.save();
        }
        catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

}
