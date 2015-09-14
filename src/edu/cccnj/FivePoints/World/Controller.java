package edu.cccnj.FivePoints.World;

import edu.cccnj.FivePoints.General.Actor;
import edu.cccnj.FivePoints.General.TickManager;

import java.util.ArrayList;

/**
 * The main loop of the program.
 *
 * Takes a list of Actors, wraps them in a TickManager, and makes them .act();
 */
public class Controller {

    /**
     * The TickManagers which control the interaction with the world.
     */
    private ArrayList<TickManager> actors = new ArrayList<>();

    /**
     * Default constructor.
     */
    public Controller(){
    }

    public void start(){
        for/*ever*/(; ;) { //  TODO: Make this run on its own thread so we can have a prettier delay in
            for (TickManager a : actors) {
                a.tick();
                try {
                    Thread.sleep(1000); // TODO: DON'T DO THIS ANYMORE
                } catch (Exception e){

                }
            }
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
     * Gets every actor of a certain class type.
     * @param classType - the type of class to search for
     * @return A list of all actors of this type.
     */
    public ArrayList<Actor> getActors(Class classType){

        ArrayList<Actor> collectedActors = new ArrayList<Actor>();

        for(TickManager tm : actors){
            if(tm.getActor().getClass() == classType)
                collectedActors.add(tm.getActor());
        }

        return collectedActors;
    }
}
