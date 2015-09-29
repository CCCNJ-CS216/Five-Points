

import java.util.ArrayList;
/**
 * Write a description of class Stats here.
 *
 * @author (Nancy)
 * @version (9.15.15)
 */
public class Stats implements Actor
{
    private ArrayList<Actor> actors;

    /**
     * Constructor for objects of class Stats
     */
    public Stats(ArrayList<Actor> a)
    {
        actors = a;
    }

    public void act(int time)
    {

    }

    public int currentCount()
    {
        // Ask the lane for the max count?
        return -1; // TODO: not this
    }

}