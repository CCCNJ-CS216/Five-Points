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
import FivePoints.Graphics.CustomGraphics;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;

/**
    Controller is the class through which the Gui and the World communicate.
    Controller holds a reference to both, and has methods for creating, starting, stopping the World.
    (The Gui should not hold a reference to world, and World should not hold a reference to Gui.)
*/
public class Controller {
    //reference to gui thread (it doesn't need to be a thread since it is the main thread)
    

    private World world;
    private Thread worldThread;
    
    private CustomGraphics graphics;
    
    @FXML
    private BorderPane rootBorderPane;
    @FXML
    private Canvas canvas;

    /**
     * Make a new controller with a given GUI. This will create a new world.
     * @param gui The FivePoints GUI instance being worked with
     */
    public Controller(){
        
        init();

    }
    
    //creates world and passes it a JavaFX Canvas
    private void init(){
        loadFXML();
        graphics = new CustomGraphics(canvas);
        world = new World(this);
        worldThread = new Thread(world);
        begin();
    }
    
    private void loadFXML(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SceneGraph.fxml"));
        
        fxmlLoader.setController(this);
        System.out.println("loadFXML");
        try{
            fxmlLoader.load();
        }catch (IOException exception){
            throw new RuntimeException(exception);
        }
    }
    
    public BorderPane getRoot(){
        if(rootBorderPane == null)System.out.println("Null BorderPane");
        return rootBorderPane;
        
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
    

    /**
     * Wake up the World's thread
     */
    public void startWorld(){
        world.start();
    }

    public void pauseWorld() throws InterruptedException{
        world.pause();
    }

    /*
        Clears the JavaFX Canvas
    */
    public void clear() {
        graphics.clear();
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
    
    
    /*
    public Shared<CustomCanvas> requestCanvas() {
        return gui.requestCanvas();
    }
    
    public Shared<Text> requestTextPane(){
        return gui.requestTextPane();
    }*/
    
    public Shared<CustomGraphics> requestGraphics(){
        return new Shared<CustomGraphics>(graphics);
    }
    @FXML
    private void handleStartAction(final ActionEvent event){
        startWorld();
        System.out.println();
    }
    
    /*
        Tell the controller to stop the sim loop.
    */
    @FXML
    private void handleStopAction(final ActionEvent event){
        try{
            pauseWorld();
        }catch(InterruptedException e){
            
        }
    }
}
