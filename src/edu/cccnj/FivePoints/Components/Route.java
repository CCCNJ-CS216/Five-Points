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
    
    public Lane getLane(int route)
    {
        return this.route.get(route).getLane();
    }
    
    public Integer getTime(int integer)
    {
        return this.route.get(integer).getTime();
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

