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
        cm.insertMapObject(firstCar);
        System.out.println(cm.toString());


    }

}

