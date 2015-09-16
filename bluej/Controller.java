

import java.util.ArrayList;

/**
 * The main loop of the program.
 *
 * Takes a list of Actors, wraps them in a TickManager, and makes them .act();
 */
public class Controller implements Runnable{

    /**
     * How long (in milliseconds) each tick
     * should be from one another.
     */
    private long tickDelay;

    /**
     * The TickManagers which control the interaction with the world.
     */
    protected ArrayList<TickManager> actors = new ArrayList<>();

    /**
     * The delay between each tick, in milliseconds Default: 1000
     * @param tickDelay
     */
    public Controller(long tickDelay)
    {
        this.tickDelay = tickDelay;
    }

    @Override
    /**
     * Run the controller
     */
    public void run(){
        for/*ever*/(; ;) {
            for (TickManager a : actors) {
                a.tick();
                try {
                    Thread.sleep(tickDelay);
                } catch (Exception e){
                    System.out.println(e.getStackTrace());
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
