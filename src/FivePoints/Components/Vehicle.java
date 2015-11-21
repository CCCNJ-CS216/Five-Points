package FivePoints.Components;

import FivePoints.General.Actor;
import FivePoints.Simulation.World;

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
        world.requestCanvas().perform(x -> x.drawRect(xpos, ypos, width, height, BLACK));
    }

   
    
}
