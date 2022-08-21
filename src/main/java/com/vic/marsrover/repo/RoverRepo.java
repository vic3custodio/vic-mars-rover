package com.vic.marsrover.repo;

import com.vic.marsrover.model.Coordinates;
import com.vic.marsrover.model.Rover;
import com.vic.marsrover.model.RoversOnMars;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
@Repository
public class RoverRepo {

    private static Map<Coordinates, Rover> rovers = new ConcurrentHashMap<>();

    @Value("${rovers.on.mars}")
    private String fileName;

    public Map<Coordinates, Rover> getRovers() {
        return rovers;
    }

    public void setRovers(Map<Coordinates, Rover> rovers) {
        this.rovers = rovers;
    }

    public void addRover(Coordinates coordinates, Rover rover) {
        if (!this.rovers.containsKey(coordinates)) {
            this.rovers.put(coordinates, rover);
        }
        else {
            throw new IllegalStateException("Rover will not be deployed. Current position is already occupied by another rover!!!");
        }
    }

    public void removeRover(Coordinates coordinates) {
        this.rovers.remove(coordinates);
    }

    public Rover getRover(String name) {
        Optional<Rover> result = this.rovers.values().stream().filter(rover -> {
            if (name.equals(rover.getName())) {
                return true;
            }
            else {
                return false;
            }
        }).findFirst();

        return result.orElse(null);
    }

    public void save(Map<Coordinates, Rover> rovers) {
        try {
            RoversOnMars roversOnMars = new RoversOnMars(rovers);

            // New file output stream for the file
            FileOutputStream fos = new FileOutputStream(fileName);

            // Serialize
            SerializationUtils.serialize(roversOnMars, fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RoversOnMars retrieve() {
        try {
            // Open FileInputStream to the file
            FileInputStream fis = new FileInputStream(fileName);

            // Deserialize
            RoversOnMars roversOnMarsDeserialized = (RoversOnMars) SerializationUtils.deserialize(fis);
            fis.close();
            return roversOnMarsDeserialized;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new RoversOnMars(new HashMap<>());
        }
    }

    public static Boolean isValidMove(Coordinates coordinates) {
        if (!rovers.containsKey(coordinates)) {
            return true;
        }
        else {
            return false;
        }
    }

}
