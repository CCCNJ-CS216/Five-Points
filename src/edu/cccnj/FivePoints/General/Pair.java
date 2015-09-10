package edu.cccnj.FivePoints.General;

/**
 * Pair is a general purpose class for coupling together
 * two objects of different or same type. (Java doesn't have tupples??)
 */
public class Pair<T1, T2> {
    /**
     * The first item of the tuple
     */
    protected T1 item1;

    /**
     * The second item of the tuple.
     */
    protected T2 item2;

    public Pair(T1 item1, T2 item2){
        this.item1 = item1;
        this.item2 = item2;
    }

    /**
     * Test to see if this pair has a value equal to that of another
     *@param otherPair - The pair to compare
     */
    public boolean equals(Pair otherPair){
        return this.item1 == otherPair.item1 && this.item2 == otherPair.item2;
    }

    public String toString(){
        return "item1: " + item1.toString() + " | item2: " + item2.toString();
    }
}
