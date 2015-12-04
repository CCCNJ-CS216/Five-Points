package FivePoints.Simulation;

import FivePoints.Components.Intersection.Intersection;
import FivePoints.Components.Intersection.LightConfiguration;
import FivePoints.Components.Intersection.TrafficLight;
import FivePoints.Components.Lane.EndLane;
import FivePoints.Components.Lane.Lane;
import FivePoints.Components.Lane.SourceLane;
import FivePoints.General.Pair;
import FivePoints.Simulation.FivePoints;
import FivePoints.Threading.Shared;
import javafx.geometry.Point2D;
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
     * Creates a default scenario of one lane approaching the intersection
     * from every direction, and adds it to the world.
     */
    public void defaultScenario(){
        Intersection intersection = new Intersection(new Point2D(400, 300), world);

        TrafficLight northLight = new TrafficLight(new LightConfiguration(3, 3, 3), new Point2D(400, 200), world);
        TrafficLight southLight = new TrafficLight(new LightConfiguration(3, 3, 3), new Point2D(400, 400), world);

        TrafficLight eastLight = new TrafficLight(new LightConfiguration(3, 3, 3), new Point2D(500, 300), world);
        TrafficLight westLight = new TrafficLight(new LightConfiguration(3, 3, 3), new Point2D(300, 300), world);

        SourceLane northLane = new SourceLane(world, 400, 0, intersection);
        SourceLane eastLane = new SourceLane(world, 500, 100, intersection);

        EndLane southLane = new EndLane(world, 400, 500);
        EndLane westLane = new EndLane(world, 0, 500);

        intersection.addBindings(
                new Pair<TrafficLight, Lane>(northLight, northLane),
                new Pair<TrafficLight, Lane>(eastLight, eastLane),
                new Pair<TrafficLight, Lane>(westLight, westLane),
                new Pair<TrafficLight, Lane>(southLight, southLane)
        );

        world.addActor(intersection);

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
