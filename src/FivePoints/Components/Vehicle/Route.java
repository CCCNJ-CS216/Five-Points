/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FivePoints.Components.Vehicle;

import FivePoints.Components.Lane.Lane;
import FivePoints.General.Pair;
import java.util.ArrayList;

/**
 * @author: Josue Gomez, Jason Dawson
 * @version: 1.1
 */
public class Route {

    private ArrayList<Pair<Lane, Integer>> route;

    /**
     * A constructor that creates a blank route
     */
    public Route() {
        route = new ArrayList<>();
    }

    /**
     * Get the lane at a given index
     *
     * @param routeIndex what index the lane has
     * @return The lane at this index
     */
    public Lane getLane(int routeIndex) {
        return this.route.get(routeIndex).getItem1();
    }
    
    /**
     * Adds a lane to the list making a route
     * 
     * @param lane
     */
    public void addStep(Lane lane){
        route.add(new Pair<>(lane, null));
    }
    /**
     *
     * @param routeIndex
     * @return
     */
    public int getTime(int routeIndex) {
        return this.route.get(routeIndex).getItem2();
    }

    /**
     * Set the time at a specific RouteIndex
     *
     * @param routeIndex The index of the route
     * @param time The time to write in it
     */
    public void setRouteTime(int routeIndex, int time) {
        this.route.get(routeIndex).setItem2(time);
    }

    /**
     * Set the time of a particular lane to a given time
     *
     * @param lane The lane to change the time of
     * @param time The time to set
     */
    public void setRouteTime(Lane lane, int time) {
        for (Pair l : route) {
            if (l.getItem1() == lane) {
                l.setItem2(time);
            }
        }
    }

    /**
     * Set a lane at an index
     *
     * @param routeIndex The index to set it at
     * @param lane The lane that is used
     */
    public void setLane(int routeIndex, Lane lane) {
        route.get(routeIndex).setItem1(lane);
    }

    /**
     * Gets the next lane by finding the next Lane in which route does not have
     * a specified time for entry.
     *
     * @return The lane, or null if it is in the final lane.
     */
    public Lane getNextLane() {
        // Finds the first lane with a null time and returns it
        for (Pair<Lane, Integer> pair : route) {
            if (pair.getItem2() == null) {
                return pair.getItem1();
            }
        }

        return null;
    }

    /**
     * Get the lane that the car is currently in
     *
     * @return The current lane, or null if the route is complete for whatever
     * reason
     */
    public Lane getCurrentLane() {
        // Finds the first lane (not the current one) with a null time, and returns the one before it.
        for (int i = 0; i < route.size(); i++) {
            if (route.get(i).getItem2() == null) {
                if (i != 0) {
                    return route.get(i - 1).getItem1();
                }
            }
        }

        return null;
    }
}
