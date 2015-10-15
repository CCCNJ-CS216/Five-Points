package edu.cccnj.FivePoints.World;

import edu.cccnj.FivePoints.Components.CarSource;
import edu.cccnj.FivePoints.Components.Lane;
import edu.cccnj.FivePoints.Components.Stats;
import edu.cccnj.FivePoints.Components.TrafficLight;
import edu.cccnj.FivePoints.General.Actor;
import edu.cccnj.FivePoints.General.TickManager;
import edu.cccnj.FivePoints.General.Picky;

import java.util.ArrayList;

/**
 * The main loop of the program.
 *
 * Takes a list of Actors, wraps them in a TickManager, and makes them .act();
 */
public class Controller {

    /**
     * How long (in milliseconds) each tick
     * should be from one another.
     */
    private long tickDelay;

    /**
     * The TickManagers which control the interaction with the world.
     */
    private ArrayList<TickManager> actors = new ArrayList<>();

    public Controller(){
        this.tickDelay = 1;
    }
    /**
     * The delay between each tick, in milliseconds Default: 1000
     * @param tickDelay How long the real time betwen each tick is in milliseconds
     */
    public Controller(long tickDelay)
    {
        this.tickDelay = tickDelay;
    }

    /**
     * Run the controller. Optionally, run it for maxTicks amount of times only
     * @param maxTicks How many ticks the controller should run for. -1 for infinite
     */
    public void run(int maxTicks){
        try {
            this.initialize();

            for (int currentTick = 0; currentTick < maxTicks; currentTick++ ) {
                System.out.println("Tick=" + currentTick);
                for (TickManager a : actors) {
                    System.out.println("Just acted on: " + a.getActor().toString());
                    a.tick(); // Makes everything happen
                    this.adjustManagers(); // Adjust every TickManager
                    try {
                        Thread.sleep(tickDelay);
                    } catch (Exception e) {
                        System.out.println(e.getStackTrace());
                    }
                }
            }
        } catch(Exception e){
            System.out.println("Something has gone horribly wrong");
        }
    }

    /**
     * Run the Controller with the default maxTicks value (9)
     */
    public void simpleRun(){
        this.run(9);
    }
    /**
     * Initialize the controller with 3 Lanes, a CarSource, and a TrafflicLight
     */
    //sbw added Stats
    public void initialize()
    {
        TrafficLight light = new TrafficLight();//sbw consider using 3-param constructor
        Lane lane1 = new Lane(light, 99);//TODO: No arbitrary maxcount
        Lane lane2 = new Lane(light, 99);//TODO: No arbitrary maxcount
        Lane lane3 = new Lane(light, 99);//TODO: No arbitrary maxcount
        ArrayList<Lane> dests = new ArrayList();  //sbw
        dests.add(lane3);  //sbw
        Stats statx = new Stats(dests);   //sbw
        CarSource source = new CarSource(this, lane1, lane2, lane3);

        Actor[] initialActors = {light, lane1, lane2, lane3, source, statx};  //sbw

        // Add all the actors to the controller
        for(Actor a: initialActors)
            this.addActor(a, 1);
        //this.addActor( a, 1);

    }
    /**
     * Add an actor to the list of running actors.
     * @param actor - The actor to add to the controller
     * @param tickEvery - How many ticks the actor should act (e.g, check for lights every how long?)
     */
    public void addActor(Actor actor, int tickEvery){
        actors.add(new TickManager(tickEvery, actor));
    }

    /**
     * Gets every TickManager of a certain class type.
     * @param classType - the type of class to search for
     * @return A list of all TickManagers of this type.
     */
    public ArrayList<TickManager> getManagers(Class classType){

        ArrayList<TickManager> collectedActors = new ArrayList<TickManager>();

        for(TickManager tm : actors){
            if(tm.getActor().getClass() == classType)
                collectedActors.add(tm);
        }

        return collectedActors;
    }

    /**
     * Gets every Actor of a certain class type
     * @param classType The type of class to search for
     * @return A list of all actors of this type
     */
    public <T extends Actor> ArrayList<T> getActors(Class classType){
        ArrayList<T> collection = new ArrayList();

        for(TickManager tm : this.getManagers(classType))
            collection.add( (T) tm.getActor());

        return collection;
    }
    /**
     * Run some adjustments on the TickManagers. Currently it will:
     *  - Adjust the cycle time of Picky classes.
     */
    public void adjustManagers(){
        class Adjustments{
            public void pickyAdjust(TickManager tm){
                if(tm.getActor() instanceof Picky){
                    tm.setTickThreshold(((Picky) tm.getActor()).getCycleTime());
                }
            }
        }

        Adjustments adjuster = new Adjustments();

        for(TickManager tm: actors){
            adjuster.pickyAdjust(tm);
        }
    }

    /**
     * Remove the actor from the list of polled objects
     * @param actor The actor to remove
     */
    public void removeActor(Actor actor){
        for(TickManager t: actors){
            if(t.getActor() == actor)
                actors.remove(actor);
        }
    }
}
