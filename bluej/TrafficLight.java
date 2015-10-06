

/**
 * TrafficLights control the lane flow.
 * Can be either RED or GREEN
 * YELLOW lights not implimented
 * 
 * @author Jason Dawson 
 * @version 10/3/2015
 */
public class TrafficLight implements Actor
{
    // A set of emum's that describe what color the trffic light is
    enum LightColors { GREEN, YELLOW, RED }
    //the stored cycle time of the traffic light defaults to 30 if nothing is set
    private int cycleTime;
    //the current time in the cycle
    private int timer;
    //the current color of the traffic light starts red
    private LightColors color;

    /**
     * the default traffic light. has a cycle time of 30 ticks and starts red
     * Should only be used for the skeleton
     */
    public TrafficLight()
    {
        cycleTime = 30;
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
     * The lights act method
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
             {
                 color = LightColors.RED;
             }
             else if (color == LightColors.RED) 
             {
                 color = LightColors.GREEN;
             }
         }
     }
     
    /**
     * override of the toString method
     * retuns a string describing the current state of the light
     */
     public String toString()
     {
        if(color == LightColors.GREEN)
        {
            return "The Light is GREEN";
        }
        else if (color == LightColors.RED)
        {
            return "The Light is RED";
        }
        else if (color == LightColors.YELLOW)
        {
            return "The Light is YELLOW";
        }
        return "the light is blank somehow. we have a problem";
    }
}
