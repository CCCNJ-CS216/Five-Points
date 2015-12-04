package FivePoints.Components.Intersection;

import FivePoints.Components.Lane.Lane;
import FivePoints.General.Actor;
import FivePoints.General.Pair;
import FivePoints.Simulation.World;

import javafx.geometry.Point2D;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Intersections bind lanes with TrafficLights. Intersections are unaware of
 * the type of lane they are looking at.
 */
public class Intersection extends Actor {

    /**
     * One traffic light is given priority
     * at a time.
     */
    private TrafficLight focusedLight;

    /**
     * This is the index of that focusedLight.
     */
    private int lightIndex;

    /**
     * Bindings between traffic lights and lanes.
     */
    private Map<TrafficLight, Lane> bindings;


    /**
     * Make this intersection
     * @param position The position of the top left corner of this intersection
     * @param world The world to actually put the intersection on
     */
    public Intersection(Point2D position, World world){
        super(position, world);
        bindings = new HashMap<>();
        lightIndex = 0;
    }

    /**
     * Create a binding between a traffic light and a Lane.
     * Lanes will then listen to this traffic light. Multiple bindings can
     * be set up so that a car will only go if BOTH of their bound lights are green.
     */
    public void addBinding(TrafficLight light, Lane lane){
        bindings.put(light, lane);
    }

    /**
     * Accept a number of bindings between traffic lights and lanes
     * @param couples
     */
    public void addBindings(Pair<TrafficLight, Lane> ... couples){
        for(Pair<TrafficLight, Lane> item : couples)
            addBinding(item.getItem1(), item.getItem2());
    }

    /* Required methods - Currently do nothing */
    public void draw(){}

    /**
     * Update all of the individual traffic lights. Then, ask all of the lanes to update.
     */
    public void update(){

        // See if we need to set a new light to focused
        if(focusedLight == null || focusedLight.getCurrentColor().equals(LightColor.RED)){
            Set<TrafficLight> lights = bindings.keySet();

            // Move to the next traffic light, or the first one if we're on the last one.
            lightIndex = (lightIndex + 1) < lights.size() ? (++lightIndex) : 0;

            focusedLight = (TrafficLight) lights.toArray()[lightIndex];
        } else
            // Update
            focusedLight.update();

        bindings.values().forEach(x -> x.update());
    }

}
