

/**
 * Write a description of class Car here.
 *
 * @author (Joseph Marrongelli / Warren Devonshire)
 * @version (9/16/2015)
 */
public class Car implements Actor
{

    //TODO: Not have these stubbs

    /**
     * Stub of class Route. Implements functions named and typed to work with the code here.
     */
    private class Route{Lane getFirstLane(){return new Lane();}Lane getNextLane(){return this.getFirstLane();}void recordTime(Lane l,int ticks){}}

    /**
     * Stub of class Lane. Implements functions named and typed to work with the code here.
     */
    private class Lane{boolean inFront(Car c){return false;}void changeLane(Car c, Lane l){}}

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
     * Constructor for objects of class Car
     */
    public Car(Route r)
    {
        this.myRoute = r;

        // Assuming CarSource puts the car in the first Lane
        this.currentLane = myRoute.getFirstLane();

        this.nextLane = myRoute.getNextLane();
    }

    /**
     * Check to see if this car can (and should) move lanes.
     * @param ticks The current tick count.
     */
    public void act(int ticks)
    {
        //checks to see if 'this' car is in from of current lane.(at intersection)
        if(currentLane.inFront(this)){

            //ask lane to remove 'this' car from itself, and add it to the nextLane of the route.
            currentLane.changeLane(this, nextLane);

            //once lanes have changed, currentLane becomes nextLane
            currentLane = nextLane;

            //record tick for the lane just entered.
            myRoute.recordTime(currentLane, ticks);

            //find out what the next step in the route will be from Route, store in 'nextLane'
            nextLane = myRoute.getNextLane();
        }
    }

}
