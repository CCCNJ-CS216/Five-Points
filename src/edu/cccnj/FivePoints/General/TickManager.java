package edu.cccnj.FivePoints.General;

/**
 * TickManagers keep an internal count of a master "tick",
 * such as one that the controller supplies, and run an action
 *
 * every certain number of ticks.
 */
public class TickManager {
    /**
     * How many ticks to perform an action on.
     */
    private int tickThreshold;

    /**
     * How many ticks have been experienced in the lifetime of this object.
     */
    protected int masterTick;

    /**
     * The actor that will act on ticks.
     */
    private Actor actor;

    /**
     * Constructor for TickManager.
     * @param threshold - How often the TickManager should cause the actor to act.
     * @param actor - The actor which will do the acting.
     */
    public TickManager(int threshold, Actor actor){
        this.tickThreshold = threshold;
        this.actor = actor;
    }

    /**
     * Return the actor object in this TickManager.
     * @return The Actor
     */
    public Actor getActor(){
        return this.actor;
    }

    /**
     * Get the master tick count for this TickManager.
     * @return
     */
    public int getMasterTick(){
        return masterTick;
    }

    /**
     * Tick the tickManager, possibly causing the actor to act.
     */
    public void tick(){
        // Increment ticks
        this.masterTick++;

        if(masterTick % tickThreshold == 0) {
            actor.act(masterTick);
        }
    }

    /**
     * Flush the current tick and force an act.
     */
    public void forceTick(){
        actor.act(masterTick);
    }
}
