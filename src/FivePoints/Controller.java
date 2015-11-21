package FivePoints;

import FivePoints.General.Pair;
import javafx.scene.text.Text;

import java.awt.*;
import java.util.concurrent.Semaphore;

/**
    Controller is the class through which the Gui and the World communicate.
    Controller holds a reference to both, and has methods for creating, starting, stopping the World.
    (The Gui should not hold a reference to world, and World should not hold a reference to Gui.)
*/
public class Controller {
    //reference to gui thread
    private FivePoints gui;

    //reference to world thread
    private World world;

    private Thread worldThread;

    /**
     * Make a new controller with a given GUI. This will create a new world.
     * @param gui The FivePoints GUI instance being worked with
     */
    public Controller(FivePoints gui){
        this.gui = gui;
        init();

    }
    
    //creates world and passes it a JavaFX Canvas
    private void init(){
        worldThread = new Thread(new World(this));
    }

    /*
        Starts World's Loop.
    */
    void start() {
        worldThread.start();
    }
    
    void stop(){

    }

    /*
        Clears the JavaFX Canvas
    */
    void clear() {
        try {
            Pair<Semaphore, CustomCanvas> canvas = requestCanvas();
            canvas.getItem1().acquire();
            canvas.getItem2().clear();
            canvas.getItem1().release();
            world.clearActors();
        } catch(Exception e){

        }
    }

    /**
     * Request the canvas as a semaphore
     * @return A semaphore for the canvas
     */
    public Pair<Semaphore, CustomCanvas> requestCanvas() {
        return gui.requestCanvas();
    }
    
    public Pair<Semaphore, Text> requestTextPane(){
        return gui.requestTextPane();
    }
}
