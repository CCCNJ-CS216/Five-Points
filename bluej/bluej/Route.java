

import java.util.ArrayList;
/**
 * @author: Josue Gomez
 * @version: 1.0
 */
public class Route
{
    public ArrayList <SimplePair> route;

    /**
     * A constructor that initalizes using 3 lanes
     * @param lane1 The first lane
     * @param lane2 The second lane
     * @param lane3 The third lane
     */
    public Route(Lane lane1, Lane lane2, Lane lane3)
    {
        route = new ArrayList<>();

        // Initialize all of the times to null
        route.add(new SimplePair(lane1, null));
        route.add(new SimplePair(lane2, null));
        route.add(new SimplePair(lane3, null));
    }

    /**
     * Default constructor
     */
    public Route(){
        System.out.println("Warning: Route created with default constructor");
    }

    /**
     * Get the lane at a given index
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
        // Finds the first lane with a null time and returns it
        for(SimplePair pair : route){
            if(pair.getTime() == null)
                return pair.getLane();
        }

        return null;
    }

    /**
     * Get the lane that the car is currently in
     * @return The current lane, or null if the route is complete for whatever reason
     */
    public Lane getCurrentLane(){
        // Finds the first lane (not the current one) with a null time, and returns the one before it.
        for(int i = 0; i < route.size(); i++){
            if(route.get(i).getTime() == null)
                if(i != 0)
                    return route.get(i-1).getLane();
        }

        return null;
    }
    }

