package edu.cccnj.FivePoints;
import edu.cccnj.FivePoints.World.*;

/**
 * The entry point for the Five-points program. Begins the main controller.
 */
public class Main {
    public static void main(String[] args){
        // Test CoordinateMap, MapObject
        CoordinateMap cm = new CoordinateMap(16, 16);

        MapObject firstCar = new MapObject(Node.Car, 4, 8, 4, 8);
        MapObject secondCar = new MapObject(Node.Car, 2, 9, 2, 9);
        cm.insertMapObject(firstCar);
        cm.insertMapObject(secondCar);
        System.out.println(cm.toString());
        cm.clearCoordinateMap();
        System.out.println(cm.toString());

        System.out.println(cm.getConflicting().size());
    }

}

