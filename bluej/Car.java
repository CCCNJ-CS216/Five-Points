

/**
 * Write a description of class Car here.
 *
 * @author (Joseph Marrongelli / Warren Devonshire)
 * @version (9/16/2015)
 */
public class Car implements Actor
{

    /*
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

        //checks to see if 'this' car is in from of current lane.(at intersection)
        if(!currentLane.isEmpty()) {
            System.out.println("My current lane is: " + currentLane.toString());
            if(currentLane.front().equals(this)){
                changeLane();
                myRoute.setRouteTime(currentLane,ticks);
            }
        }

    }

    private void changeLane(){
        currentLane.dequeue();
        nextLane.enqueue(this);
        currentLane = nextLane;
        if (myRoute.getNextLane() != null){
            nextLane = myRoute.getNextLane();
        }
    }

}
