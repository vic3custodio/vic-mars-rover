MARS ROVER Case Study
=

Application can be run both as CLI or Web Service (REST API)
-

Steps
-
1. Load the inventory of Mars Rovers that are already on Mars.
2. Generate the name of the Mars Rover (if not supplied).
3. Process the move instructions.
4. Update the inventory of Mars Rovers on Mars
5. To reset the inventory Mars Rovers, delete the file found on the application.properties (rovers.on.mars=roversOnMars.ser)

Things to further enhance.
-
1. Inventory system is very crude, it is just a serialization of an object.
2. Checking whether the rover is already on Mars is also crude.
3. Logging is just using System.out
4. Did not use interface.
5. Add more unit tests.

RUNNING AND TESTING
=

To run the application:<br/>
-

Web Service (REST API)
=
cd <project_dir>/target

java -jar vic-mars-rover-1.0-SNAPSHOT.jar

To deploy to mars and move the unnamed rover:<br/>
-
http://localhost:8080/deployAndMoveRover/position/3,4,N/instructions/f,f,r,f,f
{"name":"rover_1","position":{"coordinates":{"x":5,"y":6},"direction":"EAST"}}

http://localhost:8080/deployAndMoveRover/position/3,4,N/instructions/f,f,r,f,f
{"name":"rover_2","position":{"coordinates":{"x":4,"y":6},"direction":"EAST"}}

To deploy to mars and move the named rover:<br/>
-
http://localhost:8080/deployAndMoveRover/name/rover_2/position/3,4,N/instructions/f,f,r,f,f
Error: Rover name already exists. Cannot deploy rover with the same name!!!

http://localhost:8080/deployAndMoveRover/name/rover_3/position/3,4,N/instructions/f,f,r,f,f
{"name":"rover_3","position":{"coordinates":{"x":3,"y":6},"direction":"EAST"}}

http://localhost:8080/deployAndMoveRover/name/rover_4/position/3,4,N/instructions/b,b,r,b,b
{"name":"rover_4","position":{"coordinates":{"x":1,"y":2},"direction":"EAST"}}

To move existing named rover:<br/>
-
http://localhost:8080/moveRover/name/rover_1/instructions/f,f,r,f,f
{"name":"rover_1","position":{"coordinates":{"x":7,"y":4},"direction":"SOUTH"}}



CLI
=
To deploy to mars and move the unnamed rover:<br/>
-
java -jar vic-mars-rover-1.0-SNAPSHOT.jar "3,4,N" "f,f,r,f,f"

Rover Name: rover_1

Final Coordinates: 5 6

Final Direction: EAST

java -jar vic-mars-rover-1.0-SNAPSHOT.jar "3,4,N" "f,f,r,f,f"

Rover is about to collide. It will stay in its current position!!!

Rover Name: rover_2

Final Coordinates: 4 6

Final Direction: EAST

To deploy to mars and move the named rover:<br/>
-
java -jar vic-mars-rover-1.0-SNAPSHOT.jar "rover_2" "f,f,r,f,f"

Rover name already exists. Cannot deploy rover with the same name!!!

java -jar vic-mars-rover-1.0-SNAPSHOT.jar "rover_3" "3,4,N" "f,f,r,f,f"

Rover is about to collide. It will stay in its current position!!!

Rover Name: rover_3

Final Coordinates: 3 6

Final Direction: EAST

java -jar vic-mars-rover-1.0-SNAPSHOT.jar "rover_4" "3,4,N" "b,b,r,b,b"

Rover Name: rover_4

Final Coordinates: 1 2

Final Direction: EAST

To move existing named rover:<br/>
-
java -jar vic-mars-rover-1.0-SNAPSHOT.jar "rover_1" "3,4,N" "f,f,r,f,f"

Rover Name: rover_1

Final Coordinates: 7 4

Final Direction: SOUTH



IntelliJ
-
MarsRoverAppTest.java










