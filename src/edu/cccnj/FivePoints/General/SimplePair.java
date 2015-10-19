package edu.cccnj.FivePoints.General;

import edu.cccnj.FivePoints.Components.Lane;

/**
 * SimplePair is a wrapper of Pair.
 * All it does is bind a Lane with an Integer.
 */
public class SimplePair {

    /**SimpleLanes are Pairs at their base.*/
    private Pair<Lane, Integer> wrappedPair;

    /**
     * The constructor for a simple pair
     * @param lane The lane
     * @param time The time to bind with this Lane.
     */
    public SimplePair(Lane lane, Integer time){
        wrappedPair = new Pair(lane, time);
    }

    /**
     * @return The lane
     */
    public Lane getLane(){
        return wrappedPair.getItem1();
    }

    /**
     * @return The time
     */
    public Integer getTime(){
        return wrappedPair.getItem2();
    }

    /**
     * Set the lane
     * @param lane The lane to set
     */
    public void setLane(Lane lane){
        this.wrappedPair.setItem1(lane);
    }

    /**
     * Set the time
     * @param time The time to set on this SimplePair
     */
    public void setTime(Integer time){
        this.wrappedPair.setItem2(time);
    }
}
