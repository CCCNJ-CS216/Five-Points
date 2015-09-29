
import java.util.ArrayList;
/**
 * CarSource is a Factory for class Car. It
 * tracks how many cars have been created,
 * and will create a new Car with a predestined Route.
 * 
 * @Jason Dawson
 * @9/24/2015
 */
public class CarSource implements Actor
{
    /**
     * The total number of cars this factory has created
     */
    private int totalCars;
    
    /**
     *  A blank car
     */
    private Car newCar;

    /**
     * The blank Route 
     */
    private Route newRoute;
    
    /**
     * Referance to the Controller for finding the lanes and for adding cars to the actor list
     */
    private Controller controller;
    
    /**
     * An array list that contains all of the lanes
     */
    private ArrayList<Lane> lanes;

    /**
     * The wrong constructor
     */
    public CarSource()
    {
       System.out.println("Wrong Constructor");
    }
    
    /**
     * The constructor, requires a referance to the controller object be given to it
     */
    public CarSource(Controller c)
    {
        controller = c;
        // need a way to access the lane still. will depend on how the controller creates and stores them.
        // thought the controller's getManagers() method would work BUT lanes are not actors
        totalCars = 0;
    }
    
    /**
     * "Act" (i.e, generate a new car)
     */
    public void act(int tick)
    {
        //TODO: make the route a list of lanes
        //create a new route
        newRoute = new Route();
        //create a new car and pass it its route
        newCar = new Car(newRoute);
        //TODO: Put the Car in its first lane
        //lanes<___>.addCar(newCar);
        //add the new car to the list of actors for now cars will act on every tick
        controller.addActor(newCar, 1);
        //incriment the totalCars stat tracker by 1
        totalCars++;
    }

    /**
     * A string description of the factor
     * @return The total number of cars ever created by this factory.
     */
    public String toString()
    {
        return "Total cars: " + Integer.toString(totalCars);
    }
    
    /**
     * Accessor for the total cars created in lifetime of this object. for stat's mostly
     */
    public int getTotalCars()
    {
        return totalCars;
    }
}
