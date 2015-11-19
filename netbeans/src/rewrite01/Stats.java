package rewrite01;

import java.util.ArrayList;
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
        this.world.getTextPane().addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
           evaluate();
        });
    }
    
    public void evaluate(){
        
        ArrayList<Actor> actors = world.getCurrentActors();
        world.getTextPane().setText(Integer.toString(actors.size()));
        
    }
    
    
}
