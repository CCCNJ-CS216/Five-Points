

/**
 * Creates a synchronization
 * between two TrafficLights.
 * @author nate
 */
public class SynchronizedPanel implements Actor {

    // Light1 is considered the "master light". light2 syncs to it.
    private TrafficLight light1;

    // slave light. Syncs to what light1 is doing.
    private TrafficLight light2;

    /**
     * Create a new synchronization between two trafficLights.
     * @param light1 The first light to sync
     * @param light2 The second light to sync
     */
    public SynchronizedPanel(TrafficLight light1, TrafficLight light2){
        this.light1 = light1;
        this.light2 = light2;
    }

    /**
     * Check to see if the two traffic lights are synchronized.
     * @return True if the lights are currently in sync, false otherwise.
     */
    public boolean isInSync(){
        return light1.getCurrentColor() == light2.getCurrentColor();
    }

    /**
     * Force-synchronize the lights to the current state of light1.
     */
    public void sync(){
        light1.resetLight(light1.getCurrentColor());
        light2.resetLight(light1.getCurrentColor());
    }

    /**
     * Check to see if this reference is one of the traffic lights
     * controlled.
     * @param reference The reference to check against.
     * @return True if the reference is one of the lights.
     */
    public boolean has(TrafficLight reference){
        return light1 == reference || light2 == reference;
    }

    /**
     * Force both of the lights to be this color. Only ever remotely safe
     * for Greens
     * @param color The color to set
     */
    public void force(LightColor color){
        this.light1.resetLight(color);
        this.light2.resetLight(color);
    }

    /**
     * Get the color of the primary light right now
     * @return The current color
     */
    public LightColor getCurrentColor(){
        return this.light1.getCurrentColor();
    }

    /**
     * Update light1, and set light2 to sync to it.
     * @param ticks The current time of the simulation in ticks.
     */
    public void act(int ticks){
        light1.act(ticks);
        light2.act(ticks);

        if(!isInSync())
            this.sync();
    }
}
