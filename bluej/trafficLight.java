

/**
 * TrafficLights control the lane flow.
 * 
 * @author Jason Dawson 
 * @version 9/12/2015
 */
public class trafficLight implements Actor
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
    public trafficLight()
    {
        System.out.print("trafficLight needs to be created with an int");
    }
    
     /**
     * trafficLight constructor.  Needs to be passed an int cycleTime that determins the 
     * cycle the light will follow
     */
    public trafficLight(int cycle)
    {
        cycleTime = cycle;
        color = GREEN;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
     public void act(int tick)
     {
     }
}
