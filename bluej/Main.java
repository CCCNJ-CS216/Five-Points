

import java.util.ArrayList;

/**
 * The entry point for the Five-points program. Begins the main controller.
 */
public class Main {

        /**
     * Before the sekeleton is fully written, main is going to test (poorly) and demonstrate
     * the ability of implemented objects. Come here as a tutorial
     * @param args
     */
    public static void main(String[] args){

        // Say that the Controller should tick very often.
        final long TICK_DELAY = 1;

        /*
        // Create a new CoordinateMap of size 16, 16
        CoordinateMap cm = new CoordinateMap(16, 16);

        // Make a new car at spot 4 that is 4 long.
        MapObject firstCar = new MapObject(Node.Car, 4, 8, 4, 8);

        // Make a car at spot 2 that is 7 long and 7 high.
        MapObject secondCar = new MapObject(Node.Car, 2, 9, 2, 9);

        // Add the first car to the CoordinateMap
        cm.insertMapObject(firstCar);

        // Add the second car to the CoordinateMap
        cm.insertMapObject(secondCar);

        // See how many cars there are
        System.out.println(cm.getMapObjects(Node.Car).size());

        // Show the entire CoordinateMap
        System.out.println(cm.toString());

        // Get the conflicting (overlapping) spaces in the coordinateMap
        System.out.println(cm.getConflicting().size());

        // Empty the cars from the coordinateMap
        cm.clearCoordinateMap();

        // Make sure the coordinateMap is empty
        System.out.println(cm.toString());

*/
        //Make a new Stack
        Stack<Integer> stack = new Stack();

        // Push numbers to the stack
        stack.push(1);
        stack.push(2);

        // Test pop
        System.out.println(stack.pop().toString());

        // Get that two back
        stack.push(2);

        // Create an actor implementing class
        class MyActor implements Actor {public void act(int tick){System.exit(0);}}

        // Instantiate it
        MyActor tomCruise = new MyActor();

        // Make a Controller
        Controller controller = new Controller(TICK_DELAY);

        // Add the actor to the controller. Every 500 ticks the actor acts.
        controller.addActor(tomCruise, 500);

        // Search for MyActor actors in the Controller
        ArrayList<TickManager> actorActors = controller.getManagers(MyActor.class);

        // Did it find Tom?
        System.out.println(actorActors.size());

        // Start the controller in its own thread
        new Thread(controller).start();
    }

}

