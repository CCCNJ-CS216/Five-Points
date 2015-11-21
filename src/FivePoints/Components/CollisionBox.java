package FivePoints.Components;

import FivePoints.Simulation.World;
import javafx.geometry.Point2D;

/**
 * Collision boxes
 * @author Anthony
 */
public class CollisionBox {

    protected World world;
    protected Point2D position;

    // Bottom of collision box
    private Point2D bottomLeft;
    private Point2D bottomRight;

    // Top of collision box
    private Point2D topLeft;
    private Point2D topRight;

    /**
     * Constructor. Guarantees that the collision box is not a polygon
     * @param xPos - Center x coordinate
     * @param yPos - Center y coordinate
     * @param width How wide the object is
     * @param height How high the object is
     */
    public CollisionBox(int xPos, int yPos, int width, int height){
        this.position = new Point2D(xPos, yPos);

        bottomLeft  = new Point2D(xPos - (width / 2), yPos - (height / 2));
        bottomRight = new Point2D(xPos + (width / 2), yPos - (height / 2));

        topLeft  = new Point2D(xPos - (width / 2), yPos + (height / 2));
        topRight = new Point2D(xPos + (width / 2), yPos + (height / 2));
    }
    
    /**
     * Checks to see if the given point is in the collision box.
     * @param point The point to check
     * @return boolean
     */
    public boolean containsPoint(Point2D point){
        return
                // Check if in between left and right bounds
                point.getX() > bottomLeft.getX() && point.getX() < bottomRight.getX() &&
                // Check if in between top and bottom bounds
                point.getY() < topLeft.getY() && point.getY() > bottomLeft.getY();
    }
    
    /**
     * Checks to see if the given point is in the collision box.
     * @param x The x position of the point
     * @param y The y position of the point
     * @return boolean
     */
    public boolean containsPoint(int x, int y){
        return containsPoint(new Point2D(x, y));
    }
    
}