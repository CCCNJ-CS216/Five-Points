package rewrite01;

import javafx.scene.text.Text;



/**
 *
 * @author Warren
 */

/*
    Controller is the class through which the Gui and the World communicate.
    Controller holds a reference to both, and has methods for creating, starting, stopping the World.
    (The Gui should not hold a reference to world, and World should not hold a reference to Gui.)
*/
public class Controller {
    //reference to gui
    private Rewrite01 gui;
    private World world;
    
    public Controller(Rewrite01 gui){
        this.gui = gui;
        init();
    }
    
    //creates world and passes it a JavaFX Canvas
    private void init(){
        world = new World(this);
        
    }

    /*
        Starts World's Loop.
    */
    void start() {
        world.start();
    }
    
    /*
        Stops World's Loop.
    */
    void stop() {
        world.stop();
    }
    
    
    /*
        Clears the JavaFX Canvas
    */
    void clear() {
        gui.getCanvas().clear();
        
        
    }

    public CustomCanvas getCanvas() {
        return gui.getCanvas();
    }
    
    public Text getTextPane(){
        return gui.getTextPane();
    }
}
