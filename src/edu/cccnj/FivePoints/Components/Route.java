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
    
    public Route()
    {
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

