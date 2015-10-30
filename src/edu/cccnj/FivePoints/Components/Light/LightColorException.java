package edu.cccnj.FivePoints.Components.Light;

/**
 * This is the Exception thrown when the TrafficLight
 * tries to interact with a color of unspecified interval.
 */
public class LightColorException extends Exception {
    LightColor unspecified;

    /**
     * Set a new LightColorException with the particular unspecified color
     * @param unspecified The color which was unspecified.
     */
    public LightColorException(LightColor unspecified){
        this.unspecified = unspecified;
    }
}
