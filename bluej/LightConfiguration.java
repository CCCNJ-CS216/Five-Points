
/**
 * Holds configuration data for a traffic light.
 * Specifically, this is used to time directions
 * at an intersection.
 */
public class LightConfiguration {
    // How long it should be red
    private int redTime;

    // How long it should be green
    private int greenTime;

    // How long it should be yellow
    private int yellowTime;

    /**
     * Create a new LightConfiguration
     * @param redTime How long this light should be red
     * @param greenTime How long this light should be green
     * @param yellowTime How long this light should be yellow
     */
    public LightConfiguration(int redTime, int greenTime, int yellowTime){
        this.redTime = redTime;
        this.greenTime = greenTime;
        this.yellowTime = yellowTime;
    }

    /**
     * @return The red interval
     */
    public int getRedTime() {
        return redTime;
    }

    /**
     * @return The green interval
     */
    public int getGreenTime() {
        return greenTime;
    }

    /**
     * @return The yellow interval
     */
    public int getYellowTime() {
        return yellowTime;
    }
}
