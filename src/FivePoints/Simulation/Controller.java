package FivePoints.Simulation;

import FivePoints.Simulation.FivePoints;
import FivePoints.Threading.Shared;
import javafx.scene.text.Text;
import FivePoints.General.CustomCanvas;

/**
    Controller is the class through which the Gui and the World communicate.
    Controller holds a reference to both, and has methods for creating, starting, stopping the World.
    (The Gui should not hold a reference to world, and World should not hold a reference to Gui.)
*/
public class Controller {
    //reference to gui thread (it doesn't need to be a thread since it is the main thread)
    private FivePoints gui;

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
        world = new World(this);
        worldThread = new Thread(world);
    }

    /**
     * Start the world
     */
    public void begin(){
        if(!worldThread.isAlive())
            worldThread.start(); // Initial run
        else
            world.start(); // Unpause
    }
    /*
     * Wake up the GUI's thread
    */
    void startGUI() {
        gui.notify();
    }

    /**
     * Pauses the Thread that the GUI is running on.
     */
    void pauseGUI() throws InterruptedException{
        gui.wait();
    }

    /**
     * Wake up the World's thread
     */
    void startWorld(){
        world.start();
    }

    void pauseWorld() throws InterruptedException{
        world.pause();
    }

    /*
        Clears the JavaFX Canvas
    */
    void clear() {
        requestCanvas().perform(x -> x.clear());
    }

    /**
     * Request the canvas as a semaphore
     * @return A semaphore for the canvas
     */
    public Shared<CustomCanvas> requestCanvas() {
        return gui.requestCanvas();
    }
    
    public Shared<Text> requestTextPane(){
        return gui.requestTextPane();
    }
}
