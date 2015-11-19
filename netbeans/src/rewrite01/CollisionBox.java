
package rewrite01;

import javafx.geometry.Point2D;

/**
 *
 * @author Anthony
 */
public class CollisionBox {
    protected World world;
    protected Point2D position;
    protected int width, height;
    
    /**
     * Constructor
     * @param xpos - Center x coordinate
     * @param ypos - Center y coordinate
     * @param width
     * @param height 
     */
    public CollisionBox(int xpos, int ypos, int width, int height){
        this.position = new Point2D(xpos, ypos);
        this.width = width;
        this.height = height;
    }
    
    /**
     * Checks to see if the given point is in the collision box.
     * @param x
     * @param y
     * @return boolean
     */
    public boolean containsPoint(int x, int y){
        return (x >= position.getX()-(width/2) && x <= position.getX()+(width/2)) &&
                (y >= position.getY() - (height/2) && y <= position.getY() + (height/2));
    }
    
    /**
     * Checks to see if the given point is in the collision box.
     * @param p
     * @return boolean
     */
    public boolean containsPoint(Point2D p){
        return (p.getX() >= position.getX()-(width/2) && p.getX() <= position.getX()+(width/2)) &&
               (p.getY() >= position.getY() - (height/2) && p.getY() <= position.getY() + (height/2));
    }
    
}