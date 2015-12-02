package FivePoints.Components;

import FivePoints.General.Actor;
import FivePoints.Simulation.World;

import static javafx.scene.paint.Color.BLACK;

public class Vehicle extends Actor {

    /**
     * List of Lanes and entry time
     */
    private Route myRoute;

    /**
     * Lane the car is currently in
     */
    private Lane currentLane;

    /**
     * Lane car will be in after the current lane
     */
    private Lane nextLane;

    /**
     * Tick when the car last moved.
     */
    private int lastMove = 0;

    /**
     * A modifier that affects the time it takes a car to tranverse lane segments
     */
    private int speed = 3;
    
    private int timer;

    public Vehicle(World world, int xpos, int ypos) {
        super(world, xpos, ypos);
    }

    //Accessor methods
    public Route getRoute() {
        return myRoute;
    }

    public Lane getNextLane() {
        return nextLane;
    }
 
    @Override
    public void update() {
        if (xpos >= 800) {
            xpos = -5;
        }
        if (ypos >= 600) {
            ypos = -5;
        }
        xpos += 1;
        ypos += 1;
    }
    @Override
    public void draw() {
        world.requestCanvas().perform(x -> x.drawRect(xpos, ypos, width, height, BLACK));
    }
    
    public boolean isReady(){
        return speed == lastMove;
    }
        /**
     * Change the lane to the nextLane and set the departure time of the current
     * lane
     *
     * @param ticks The timestamp
     */
    public void changeLane()
    {
            currentLane = nextLane;
            // Write the time
            myRoute.setRouteTime(currentLane, timer);
        // Set the next lane if it exists
        if (myRoute.getNextLane() != null)
            nextLane = myRoute.getNextLane();
    }
}
