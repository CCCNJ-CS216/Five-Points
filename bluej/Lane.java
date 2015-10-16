

import java.util.ArrayList;

/** 
 * @author (Reno Levari)
 * @version (9/15/15)
 */

/**
 * Lanes are the containers for most of the
 * actual actors themselves. It contains a
 * queue of cars which are controlled by a TrafficLight,
 * and optionally constrained by a maxCount.
 */
public class Lane implements Actor
{
    /** The traffic light this lane looks at*/
    private TrafficLight trafficLight;

    /** The cars that this lane currently has */
    private Queue<Car> cars;

    /** The maximum number of cars allowed in this lane */
    private int maxcount;

    /**
     * Create a new lane with a give TrafficLight
     * @param tLight The light to make this lane look at
     */
    public Lane(TrafficLight tLight)
    {
        trafficLight = tLight;
        cars = new Queue<>();
        maxcount = 0; //Infinite lane

    }

    /**
     * Create a lane with a specified maxCount
     * @param tLight The light to make this lane look at
     * @param maxc How many cars will be allowed in this Lane at a time
     */
    public Lane(TrafficLight tLight, int maxc)
    {
        trafficLight = tLight;  //sbw this!
        cars = new Queue<>();
        maxcount = maxc;

    }

    /**
     * Remove the first car and return it
     * @return The first car in the lane
     */
    public Car dequeue()
    {
        return cars.dequeue();
    }

    /**
     * Add a car to the back of the queue
     * @param c The car to add
     */
    public void  enqueue(Car c)
    {   
        if (!this.isFull())
            cars.enqueue(c);
    }

    /**
     * Check to see if the number of cars exceeds maxCount
     * @return True if the lane is full, false otherwise
     */
    public boolean isFull()
    {
        if ( cars.size() >= maxcount && maxcount  != 0)
            return true;

        return false;

    }

    /**
     * Check to see if the lane has any cars
     * @return True if there are no cars, false otherwise
     */
    public boolean isEmpty()
    {
        return cars.isEmpty();
    }

    /**
     * Non-destructively look at the car in the front
     * of the queue
     * @return The car in the front of the lane
     */
    public Car front()
    {
        return cars.front();
    }

    /**
     * Get how many cars are in this lane
     * @return The number of cars in this lane
     */
    public int size()
    {
        return cars.size();
    }

    /**
     * @return The traffic light this lane sees
     */
    public TrafficLight getTrafficLight()
    {
        return trafficLight;
    }

    /**
     * @return A deep copy of the entire queue of cars that this lane has.
     */
    public Queue getQueue()
    {
        return cars.clone();
    }

    /**
     * Set the traffic light that this lane looks at to a new one
     * @param tLight The light to make this lane look at
     */
    public void setTrafficLight(TrafficLight tLight)
    {
        trafficLight = tLight;
    }

    /**
     * See how many cars are allowed in this lane
     * @return The maxCount of this lane
     */
    public int getMaxCount()
    {
        return maxcount;
    }

    /**
     * Act. Make the car in the front of the lane tick if
     * there is one.
     * @param tick
     */
    public void act(int tick){
        if(!cars.isEmpty())
           cars.front().act(tick);

        //Debug. TODO
        System.out.println("Hi there!  I have " + size() +" cars inside.");
    }

    /**
     * Look at a car in a given position i n this lane
     * @param location The index to peak at
     * @return The car at location
     */
    public Car peek(int location){
        return cars.peek(location);
    }
}