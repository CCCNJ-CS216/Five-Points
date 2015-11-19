package rewrite01;

import static javafx.scene.paint.Color.BLACK;


public class Vehicle extends Actor {

    public Vehicle(World world, int xpos, int ypos) {
        super(world, xpos, ypos);
    }



    @Override
    public void update() {
        if(xpos >= 800)xpos = -5;
        if(ypos >= 600)ypos = -5;
        xpos += 1;
        ypos += 1;
        
        
    }

    @Override
    public void draw() {
        world.getCanvas().drawRect(xpos,ypos,width,height, BLACK);
    }

   
    
}
