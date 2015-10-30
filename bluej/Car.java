
import java.util.Random;

/**
 * Write a description of class Car here.
 *
 * @author (Joseph Marrongelli / Warren Devonshire)
 * @version (9/16/2015)
 */
public class Car implements Actor
{

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
     * Random number generator needed for approximating random driver behavior.
     */
    private Random rgen = new Random();
    
    /**
     * Tick when the car last moved.
     */
    private int lastMove = 0;

    //Accessor methods

    public Route getRoute(){
        return myRoute;
    }


    public Lane getNextLane(){
        return nextLane;
    }


    /**
     * Constructor for objects of class Car
     */
    public Car(Route r)
    {
        this.myRoute = r;

        // Assuming CarSource puts the car in the first Lane
        this.currentLane = myRoute.getLane(0);

        this.nextLane = myRoute.getNextLane();
    }

    /**
     * Check to see if this car can (and should) move lanes.
     * @param ticks The current tick count.
     */
    public void act(int ticks)
    {
       if(nextLane.getTrafficLight() == null){
            changeLane(ticks);
        } else if(nextLane.getTrafficLight().getColor() == LightColor.GREEN){
            changeLane(ticks);
        } else if(nextLane.getTrafficLight().getColor() == LightColor.YELLOW && rgen.nextBoolean()){
            changeLane(ticks);
        }
    }

    /**
     * Change the lane to the nextLane and set
     * the departure time of the current lane
     * @param ticks The timestamp
     */
    private void changeLane(int ticks){

        if(nextLane != currentLane && lastMove != ticks){
            // Move the car
            currentLane.dequeue();
            nextLane.enqueue(this);
            currentLane = nextLane;

            // Write the time
            myRoute.setRouteTime(currentLane, ticks);
            
            //update the lastMove tick
            lastMove = ticks;
        }

        // Set the next lane if it exists
        if (myRoute.getNextLane() != null)
            nextLane = myRoute.getNextLane();
    }

}
