package FivePoints;

/**
 *
 * @author Warren
 */
public abstract class Actor {
    protected World world;
    protected int xpos, ypos, width, height;
    
    
    public Actor(World world){
        this.world = world;
    }
    
    public Actor(World world, int xpos, int ypos){
        this.world = world;
        this.xpos = xpos;
        this.ypos = ypos;
        width = 5;
        height = 5;
    }
    
    public abstract void update();

    public abstract void draw();
}
