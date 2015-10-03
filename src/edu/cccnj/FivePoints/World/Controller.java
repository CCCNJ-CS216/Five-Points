package edu.cccnj.FivePoints.World;

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

    /**
     * The delay between each tick, in milliseconds Default: 1000
     * @param tickDelay
     */
    public Controller(long tickDelay)
    {
        this.tickDelay = tickDelay;
    }

    /**
     * Run the controller
     */
    public void run(){
        try {
            for/*ever*/ (; ; ) {
                for (TickManager a : actors) {
                    a.tick(); // Makes everything happen
                    try {
                        Thread.sleep(tickDelay);
                    } catch (Exception e) {
                        System.out.println(e.getStackTrace());
                    }
                }
            }
        } catch(Exception e){
            System.out.println("Something has gone horribly wrong, but we're going to try again anyway.");
            this.run();
        }
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
}
