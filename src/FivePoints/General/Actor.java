package FivePoints.General;

import FivePoints.Simulation.World;
import javafx.geometry.Point2D;

/**
 *
 * @author Warren
 */
public abstract class Actor {
    protected World world;
    protected int xpos, ypos, width, height;

    /**
     * Create an actor from an existing world.
     * @param world The world to use
     */
    public Actor(World world){
        this.world = world;
    }

    /**
     * Create an actor using a point
     * @param point The point to use
     * @param world The world
     */
    public Actor(Point2D point, World world){
        this.world = world;

        this.xpos = (int)point.getX();
        this.ypos = (int)point.getY();

        width = 5;
        height = 5;
    }

    /**
     * Create an Actor from a world and a point, decoupled.
     * @param world
     * @param xpos
     * @param ypos
     */
    public Actor(World world, int xpos, int ypos){
        this.world = world;
        this.xpos = xpos;
        this.ypos = ypos;
        width = 5;
        height = 5;
    }

    /**
     * Update this particular actor (Act)
     */
    public abstract void update();

    /**
     * Draw the actor using the world's methods
     */
    public abstract void draw();
}
