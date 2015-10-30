import java.util.ArrayList;

/**
 * The TrafficLight changes its colors based on variable
 * intervals.
 */
public class TrafficLight implements Actor {

    /**
     * The color that the light currently is.
     */
    private LightColor currentColor;

    /**
     * How long each color should last.
     */
    private ArrayList<Pair<LightColor, Integer>> intervals;

    /**
     * How long the light has been its current color
     */
    private int currentTime;

    /**
     * Set the intervals for the trafficLight to run on, and assume that
     * Green is the starting value.
     * @param greenTime The amount of time the traffic light should be green.
     * @param redTime The amount of time the traffic light should be red
     * @param yellowTime The amount of time the traffic light should be yellow
     */
    public TrafficLight(int greenTime, int redTime, int yellowTime){
        intervals = new ArrayList<>();

        this.setInterval(LightColor.GREEN, greenTime);
        this.setInterval(LightColor.RED, redTime + yellowTime);//adds yellowTIme so YELLOW, GREEN doesn't happen
        this.setInterval(LightColor.YELLOW, yellowTime);

        this.currentColor = LightColor.GREEN;
    }

    /**
     * Make a traffic light with the default intervals and initial light color
     * @param greenTime The amount of time the traffic light should be green.
     * @param redTime The amount of time the traffic light should be red
     * @param yellowTime The amount of time the traffic light should be yellow
     * @param initialColor The intial color to set the traffic light to
     */
    public TrafficLight(int greenTime, int redTime, int yellowTime, LightColor initialColor){
        intervals = new ArrayList<>();

        this.setInterval(LightColor.GREEN, greenTime);
        this.setInterval(LightColor.RED, redTime + yellowTime);// adds yellowTime so YELLOW, GREEN doesn't happen
        this.setInterval(LightColor.YELLOW, yellowTime);

        this.currentColor = initialColor;
    }

    /**
     * Increment the light
     */
    public void tick(){
        currentTime++;

        for(Pair<LightColor, Integer> couple : intervals) {
            if (couple.getItem1() == currentColor && currentTime >= couple.getItem2())
                changeLight();
        }
    }

    /**
     * Changes the light color depending on how traffic lights change
     */
    public void changeLight(){
        currentTime = 0;

        if(currentColor == LightColor.GREEN)
            currentColor = LightColor.YELLOW;
        else if(currentColor == LightColor.YELLOW)
            currentColor = LightColor.RED;
        else if(currentColor == LightColor.RED)
            currentColor = LightColor.GREEN;
    }

    /**
     * Reset the color of the light to a certain color
     * @param to The color to set the light to.
     */
    public void resetLight(LightColor to){
        currentTime = 0;
        this.currentColor = to;
    }

    /**
     * Set the interval of the color in the traffic light
     * to a specified amount
     * @param color The color to specify the interval for
     * @param interval The interval to set
     */
    public void setInterval(LightColor color, int interval){

        // Try to replace the current interval
        for(int i = 0; i < intervals.size() - 1; i++){
            if(intervals.get(i).getItem1().equals(color)) {
                intervals.remove(i);

                // It doesn't matter where it goes
                intervals.add(new Pair<LightColor, Integer>(color, interval));
                return;
            }
        }

        // If the method gets here, it means that there is no specified interval
        // for this color. Thus, it is just added.
        intervals.add(new Pair<LightColor, Integer>(color, interval));
    }

    /**
     * Gets the color
     * @param color
     * @throws LightColorException
     * @return The interval for the TrafficLight
     */
    public int getInterval(LightColor color) throws LightColorException {
        for(Pair<LightColor, Integer> interval : intervals)
            if(interval.getItem1().equals(color))
                return interval.getItem2();
        throw new LightColorException(color);
    }

    /**
     * Gets the color of the light
     * @return The current color of this traffic light
     */
    public LightColor getCurrentColor(){
        return this.currentColor;
    }

    /**
     * Suggest what a car approaching this traffic light should do
     * @return LightSuggestion.PROCEED if the yellow light is less than half way done, STOP otherwise.
     */
    public LightSuggestion suggest(){

        // Green light
        if(currentColor == LightColor.GREEN)
            return LightSuggestion.PROCEED;

        // Red light
        if(currentColor == LightColor.RED)
            return LightSuggestion.STOP;

        try {
            // Yellow light
            if (currentTime == 0 || (this.getInterval(LightColor.YELLOW) / 2) > currentTime)
                return LightSuggestion.PROCEED;
            else
                return LightSuggestion.STOP;

        } catch(LightColorException e){
            System.out.println("ERROR: "+e.toString()+" not set.");
            System.exit(1);
        }
        return null;
    }

    @Override
    public String toString(){
        return "Light: " + super.toString() + "\n Color: " + getCurrentColor().toString() + "\n";
    }

    /**
     * Make this Actor Act.
     * @param ticks The current time in the simulation
     */
    public void act(int ticks){
        this.tick();
    }
}



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

             if(color == LightColors.YELLOW){
                 color = LightColors.RED;
                 timer = cycleTime;
                } else if (color == LightColors.RED){
                 color = LightColors.GREEN;
                 timer = cycleTime;
                } else if (color == LightColors.GREEN){
                  color = LightColors.YELLOW;
                  timer = 1;
                }

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
