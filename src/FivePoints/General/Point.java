package FivePoints.General;

/**
 * Tracks a point on a coordinate grid in the form
 * (x, y).
 */
public class Point {
    /**
     * The actual point
     */
    private Pair<Integer, Integer> point;

    /**
     * Creates a new point given the x and y positions
     * @param x The x-value of this point
     * @param y The y-value of this point
     */
    public Point(int x, int y){
        point = new Pair<Integer, Integer>(x, y);
    }

    /**
     * Gets the x-value
     * @return
     */
   public int x(){
       return point.getItem1();
   }

    /**
     * Gets the y-value
     * @return The y value
     */
    public int y(){
        return point.getItem2();
    }
}
