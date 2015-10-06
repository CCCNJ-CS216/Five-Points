package edu.cccnj.FivePoints.Components;

import edu.cccnj.FivePoints.Components.Lane;
import edu.cccnj.FivePoints.General.SimplePair;

import java.util.ArrayList;
/**
 * @author: Josue Gomez
 * @version: 1.0
 */
public class Route
{
    public ArrayList <SimplePair> route = new ArrayList <>();

    /**
     * A constructor that initalizes using 3 lanes
     * @param lane1
     * @param lane2
     * @param lane3
     */
    public Route(Lane lane1, Lane lane2, Lane lane3)
    {
        route.add(new SimplePair(lane1, null));
        route.add(new SimplePair(lane2, null));
        route.add(new SimplePair(lane3, null));
    }

    /**
     * Default constructor
     */
    public Route(){

    }
    /**
     * Get the lane
     * @param routeIndex what index the lane has
     * @return The lane at this index
     */
    public Lane getLane(int routeIndex)
    {
        return this.route.get(routeIndex).getLane();
    }

    /**
     *
     * @param routeIndex
     * @return
     */
    public Integer getTime(int routeIndex)
    {
        return this.route.get(routeIndex).getTime();
    }

    /* Warning: Everything added below is to remove the stubs from Car. They may be removed in the future */

    /**
     * Get the first Lane of the route
     * @return
     */
    public Lane getFirstLane(){
        return this.route.get(0).getLane();
    }


    /**
     * Set the time at a specific RouteIndex
     * @param routeIndex The index of the route
     * @param time The time to write in it
     */
    public void setRouteTime(int routeIndex, int time){
        this.route.get(routeIndex).setTime(time);
    }

    /**
     * Set the time of a particular lane to a given time
     * @param lane The lane to change the time of
     * @param time The time to set
     */
    public void setRouteTime(Lane lane, int time){
        for(SimplePair l : route){
            if(l.getLane() == lane)
                l.setTime(time);
        }
    }

    /**
     * Set a lane at an index
     * @param routeIndex The index to set it at
     * @param lane The lane that is used
     */
    public void setLane(int routeIndex, Lane lane){
        route.get(routeIndex).setLane(lane);
    }

    /**
     * Gets the next lane by finding the next Lane in which route does
     * not have a specified time for entry.
     * @return The lane, or null if it is in the final lane.
     */
    public Lane getNextLane(){

        for(SimplePair pair: route){
            if(pair.getTime() == null)
                return pair.getLane();
        }

        return null;
    }
    }

