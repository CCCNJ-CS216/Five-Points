package FivePoints.Simulation;


import java.util.ArrayList;
import java.util.Random;

import FivePoints.Components.Stats;
import FivePoints.Components.Vehicle;
import FivePoints.General.Actor;
import FivePoints.General.CustomCanvas;
import FivePoints.Threading.Shared;

import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;



/**
 *
 * @author Warren
 */

/*
    World is a Thread
    It's handle method is called by JavaFX every 1/60th of a second.(60fps)
*/
public class World implements Runnable {

    // Target FPS (controls Thread.sleep)
    private static final double FPS=60.0;

    /*
        Arraylists of actors to be updated and drawn in the loop.
        newActors(created by a current actor, added to currentActors at start/end of loop.) Temporary
        deadActors(to be used by stats)
        An Actor should only be in one list at a time.
    */
    private ArrayList<Actor> newActors;
    private ArrayList<Actor> currentActors;
    private ArrayList<Actor> deadActors;
    
    private Stats stats;

    private boolean paused;
    /*
        Will ask controller for things it needs from gui.(like the canvas).
    */
    private final Controller controller;
    
    public void clearActors(){
        newActors = new ArrayList<>();
        currentActors = new ArrayList<>();
        deadActors = new ArrayList<>();
    }
    /*
        Main Update And Draw loop for actors.
    */
    @Override
    public void run() {
        for(;;) {
            // Cause GUI delay
            try {
                Thread.sleep((int)(1000 / FPS));
            } catch(Exception e){
                System.out.println(e.getStackTrace());
            }

            if(paused)
                continue;
            //gets canvas from the controller and clears it.
            controller.clear();

            //new Actors are added to currentActors at the beginning of every loop.
            newActors.forEach(a -> currentActors.add(a));

            //newActors is emptied, so the same Actors aren't added to currentActors again next frame.
            newActors.clear();

            //update all currentActors
            currentActors.stream().forEach(a -> a.update());
            //draw all currentActors
            currentActors.stream().forEach(a -> a.draw());
        }
    }


    /*
        Constructor
    */
    public World(Controller controller){
        super();
        this.controller = controller;
        init();
    }
    
    /*
        Init method. create the initial actors.
    */
    private void init(){
        newActors = new ArrayList();
        currentActors = new ArrayList();
        deadActors = new ArrayList();
        
        //create carSource and inital Lanes(if any).
        //Load image data to be held by World and passed onto objects during construction.
        //OR actors will simply hold a reference to World to get image data.
        Random rand = new Random();
        /*
        for(int i = 0; i < 100; i++){
            currentActors.add(new Vehicle(this,rand.nextInt(800),rand.nextInt(600)));
        }
        */

        controller.requestCanvas().perform(x ->
                x.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
                    Actor temp = new Vehicle(getWorld(), (int) event.getX(), (int) event.getY());
                    newActors.add(temp);
                }));

       
       stats = new Stats(this);
        
    }
    
    /*
        Load Images
    */
    private void loadImages(){
        
    }

    public void pause(){
        paused = true;
    }

    public void start(){
        paused = false;
    }

    public Shared<CustomCanvas> requestCanvas() {
        return controller.requestCanvas();
    }

    public Shared<Text> requestTextPane(){
        return controller.requestTextPane();
    }

    public World getWorld(){
        return this;
    }

    public ArrayList<Actor> getDeadActors(){
        return deadActors;
    }
    
    public ArrayList<Actor> getCurrentActors(){
        return currentActors;
    }
}
