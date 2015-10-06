
import java.util.ArrayList;
/**
 * Write a description of class Stats here.
 *
 * @author (Nancy, Jamie)
 * @version (Awesome Version10.6.15)
 */
public class Stats implements Actor
{
    private ArrayList<Lane> destLanes;

    /**
     * Constructor for objects of class Stats
     */
    public Stats(ArrayList<Lane> destLanes)
    {
        destLanes = new ArrayList<Lane>();
    }

    public void act(int time)
    {
        if(time % 5 ==0)
        {
            currentCount(time);

        }
    }

    public void currentCount(int time){
        double total=0;
        for(Lane queue: destLanes){
            total=total+queue.size();

        }
        System.out.println("the average time per car is:"+ total/time);
    }

    public int getQueueSize()
    {

        return -1; // TODO: not this
    }

}