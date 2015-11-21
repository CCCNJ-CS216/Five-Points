package FivePoints;

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

        try {
            world.requestCanvas().getItem1().acquire();
            this.world.requestTextPane().getItem2().addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
                evaluate();
            });
            world.requestCanvas().getItem1().release();
        } catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }
    
    public void evaluate(){
        
        ArrayList<Actor> actors = world.getCurrentActors();
        try {
            world.requestTextPane().getItem1().acquire();
            world.requestTextPane().getItem2().setText(Integer.toString(actors.size()));
            world.requestTextPane().getItem1().release();
        } catch (Exception e){

        }
    }
    
    
}
