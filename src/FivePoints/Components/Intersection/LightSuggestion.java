package FivePoints.Components.Intersection;

/**
 * A simple enum for determining whether or not a car should proceed
 * through a traffic light. For right now, this is determined by TrafficLight
 * by measuring if the yellow light is more than half way done.
 *
 * It is called suggestion because, in the event that Cars eventually get a Speed
 * attribute, they may choose to reject the Light's suggestion for their safety.
 * @author Nate
 * @version 10/28/15
 */
public enum LightSuggestion {
    // Go through the light
    PROCEED,

    //Don't go through the light.
    STOP
}
