

/**
 * SimplePair is a wrapper of Pair.
 * All it does is bind a Lane with an Int.
 */
public class SimplePair {
    private Pair<Lane, Integer> wrappedPair;

    /**
     * The constructor for a simple pair
     * @param lane - The l
     * @param integer
     */
    public SimplePair(Lane lane, Integer integer){
        wrappedPair.item1 = lane;
        wrappedPair.item2 = integer;
    }

    /**
     * Get the lane
     * @return
     */
    public Lane getLane(){
        return wrappedPair.item1;
    }

    /**
     * Get the integer
     * @return
     */
    public Integer getInteger(){
        return wrappedPair.item2;
    }

    /**
     * Set the lane
     * @param lane
     */
    public void setLane(Lane lane){
        this.wrappedPair.setItem1(lane);
    }

    /**
     * Set the integer
     * @param integer
     */
    public void setInteger(Integer integer){
        this.wrappedPair.setItem2(integer);
    }
}
