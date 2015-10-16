

/**
 * TrafficLights control the lane flow.
 * Can be either RED or GREEN
 * YELLOW lights not implemented
 * 
 * @author Jason Dawson 
 * @version 10/3/2015
 */
public class TrafficLight implements Actor
{
    /**
     * How often the light changes.
     * Defaults to 3 if nothing is set.
     */
    private int cycleTime;

    /** The current time in the cycle*/
    private int timer;

    /**The current color of the trafficlight*/
    private LightColors color;

    /**
     * The default traffic light. has a cycle time of 3 ticks and starts red
     * Should only be used for the skeleton.
     */
    public TrafficLight()
    {
        cycleTime = 3;   //sbw test
        timer = cycleTime;
        color = LightColors.RED;
    }
    
     /**
     * TrafficLight constructor. 
     * Sets the cycle time that the light follows and the starting light color
     */
    public TrafficLight(int cycle, LightColors initColor)
    {
        cycleTime = cycle;
        timer = cycleTime;
        color = initColor;
    }
    
    /**
     * Returns the curent color of the traffic light
     */
    public LightColors getColor()
    {
        return color;
    }

    /**
     * The light's act method
     * depreciates the cycle time by 1 each tick
     * at 0 changes the light to the next color
     */
     public void act(int tick)
     {
         timer--;
         if(timer <= 0)
         {
             timer = cycleTime;

             if(color == LightColors.GREEN)
                 color = LightColors.RED;
             else if (color == LightColors.RED)
                 color = LightColors.GREEN;

         }
         System.out.println("The light is " + color);//Maybe move this to Stats?
     }
     
    /**
     * override of the toString method
     * retuns a string describing the current state of the light
     */
     public String toString()
     {
        if(color == LightColors.GREEN)
            return "The Light is GREEN";
        else if (color == LightColors.RED)
            return "The Light is RED";
        else if (color == LightColors.YELLOW)
            return "The Light is YELLOW";

        return "the light is blank somehow. we have a problem";
    }
}
