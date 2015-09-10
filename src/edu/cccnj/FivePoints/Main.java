package edu.cccnj.FivePoints;
import edu.cccnj.FivePoints.World.*;

/**
 * The entry point for the Five-points program. Begins the main controller.
 */
public class Main {
    /**
     * Before the controller is fully written, main is going to test (poorly) and demonstrate
     * the ability of implemented objects.
     * @param args
     */
    public static void main(String[] args){

        //Create a new CoordinateMap of size 16, 16
        CoordinateMap cm = new CoordinateMap(16, 16);

        // Make a new car at spot 4 that is 4 long.
        MapObject firstCar = new MapObject(Node.Car, 4, 8, 4, 8);

        // Make a car at spot 2 that is 7 long and 7 high.
        MapObject secondCar = new MapObject(Node.Car, 2, 9, 2, 9);

        // Add the first car to the CoordinateMap
        cm.insertMapObject(firstCar);

        // Add the second car to the CoordinateMap
        cm.insertMapObject(secondCar);

        // Show the entire CoordinateMap
        System.out.println(cm.toString());

        // Get the conflicting (overlapping) spaces in the coordinateMap
        System.out.println(cm.getConflicting().size());

        // Empty the cars from the coordinateMap
        cm.clearCoordinateMap();

        // Make sure the coordinateMap is empty
        System.out.println(cm.toString());

        // Exit the program
        System.exit(0);
    }

}

