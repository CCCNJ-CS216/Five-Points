

/**
 * CarSource is a Factory for class Car. It
 * tracks how many cars have been created,
 * and will create a new Car with a predestined Route.
 * 
 * @author
 * @version (a version number or a date)
 */
public class CarSource implements Actor
{
    /**
     * The total number of cars this factory has created
     */
    private int totalCars;


    /**
     * The lane to put the new car on
     */
    private Lane parentLane;

    /**
     * Constructor for objects of class CarSource
     */
    public CarSource()
    {
        // Initialize instance variables
        totalCars = 0;
    }
    
    /**
     * "Act" (i.e, generate a new car)
     */
    public void act(int tick)
    {
        //TODO: Generate a car here, put it in the parentLane
    }

    /**
     * A string description of the factor
     * @return The total number of cars ever created by this factory.
     */
    public String toString()
    {
        return "Total cars: " + Integer.toString(totalCars);
    }
}
