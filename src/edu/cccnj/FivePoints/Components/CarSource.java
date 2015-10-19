
package edu.cccnj.FivePoints.Components;
import edu.cccnj.FivePoints.General.Actor;
import edu.cccnj.FivePoints.World.Controller;

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
     * Reference to the Controller for finding the lanes and for adding cars to the actor list
     */
    private Controller controller;
    
    /**
     * An ArrayList that contains all of the lanes
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
     * The constructor, requires a reference to the controller object be given to it
     * this one id for the skeleton and requires that the three lane segments be given too it in the order:
     * first, middle, last.
     * @param c The controller
     * @param first The first lane
     * @param middle The middle lane
     * @param end The last lane
     */
    public CarSource(Controller c, Lane first, Lane middle, Lane end)
    {
        controller = c;
        totalCars = 0;

        lanes = new ArrayList();
        lanes.add(0, first);
        lanes.add(1, middle);
        lanes.add(2, end);
    }
    
    /**
     * "Act" (i.e, generate a new car)
     */
    public void act(int tick)
    {
        //create a new route
        newRoute = new Route(lanes.get(0), lanes.get(1), lanes.get(2));

        // Set the route time of the first lane to this time
        newRoute.setRouteTime(lanes.get(0), tick);

        //create a new car and pass it its route
        newCar = new Car(newRoute);

        // Put the car in the first lane
        lanes.get(0).enqueue(newCar);
        //increment the totalCars stat tracker by 1
        totalCars++;
    }

    /**
     * A string description of the factory
     * @return The total number of cars ever created by this factory.
     */
    public String toString()
    {
        return "Total cars: " + Integer.toString(totalCars);
    }
    
    /**
     * Accessor for the total cars created in the lifetime of this object. Mainly used by the stat's 
     */
    public int getTotalCars()
    {
        return totalCars;
    }
}
