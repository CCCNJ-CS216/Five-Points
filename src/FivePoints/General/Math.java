package FivePoints.General;

import javafx.geometry.Point2D;

import java.util.Arrays;

/**
 * Static class used for mathematical operations
 * @author  nate
 */
public abstract class Math {

    /**
     * Returns the average of a set of data
     * @param data The data to use
     * @return The average of data
     */
    public static double average(double[] data){
        return Arrays.stream(data).reduce(0, (a, b) -> a + b) / data.length;
    }

    /**
     * Overload of average to work with only two items
     * @param item1 The first item
     * @param item2 The second item
     * @return The average of item1 and item2
     */
    public static double average(double item1, double item2){
        return (item1 + item2) / 2;
    }

    /**
     * Calculates the midpoint of two points
     * @param point1 The first point to find the midpoint of
     * @param point2 The second point to find the midpoint of
     * @return The midpoint
     */
    public static Point2D midpoint(Point2D point1, Point2D point2){
        double midX = Math.average(point1.getX(), point2.getX());
        double midY = Math.average(point1.getY(), point2.getY());

        return new Point2D(midX, midY);
    }


}
