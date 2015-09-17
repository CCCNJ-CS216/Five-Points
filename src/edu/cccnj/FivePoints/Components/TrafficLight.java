package edu.cccnj.FivePoints.Components;

import edu.cccnj.FivePoints.General.Actor;

/**
 * TrafficLights control the lane flow.
 * 
 * @author Jason Dawson 
 * @version 9/12/2015
 */
public class TrafficLight implements Actor
{
    // instance variables - replace the example below with your own
    private int cycleTime;
    public final int GREEN = 1;
    public final int YELLOW = 2;
    public final int RED = 3;
    private int color;

    /**
     * traffic light can not be built with an empty Constructor
     */
    public TrafficLight()
    {
        System.out.print("trafficLight needs to be created with an int");
    }
    
     /**
     * trafficLight constructor.  Needs to be passed an int cycleTime that determins the 
     * cycle the light will follow
     */
    public TrafficLight(int cycle)
    {
        cycleTime = cycle;
        color = GREEN;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  tick a sample parameter for a method
     * @return     the sum of x and y 
     */
     public void act(int tick)
     {
     }
}
