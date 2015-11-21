package FivePoints.Components;

import java.util.ArrayList;

import FivePoints.General.Actor;
import FivePoints.Simulation.World;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Warren
 */
public class Stats {
    private final World world;
    private ArrayList<Actor> deadActors;
    
    public Stats(World world){
        this.world = world;

        world.requestTextPane().perform(x -> x.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            evaluate();
        }));

    }
    
    public void evaluate(){
        
        ArrayList<Actor> actors = world.getCurrentActors();
        world.requestTextPane().perform(x ->  x.setText("Actors: " + actors.size()));
    }
    
    
}
