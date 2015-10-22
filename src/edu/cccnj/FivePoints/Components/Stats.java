package edu.cccnj.FivePoints.Components;
import edu.cccnj.FivePoints.Components.Lane;
import edu.cccnj.FivePoints.Components.Car;
import edu.cccnj.FivePoints.Components.Lane;
import edu.cccnj.FivePoints.General.Actor;
import edu.cccnj.FivePoints.General.Queue;

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
            mrFive();

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

    public void mrFive()
    {
        Queue<Car> cars =destLanes.get(0).getQueue();
        int stat1 = 0;
        int stat2=0;
        
        for (int i=0; i<5; i++){
            stat1 = destLanes.get(0).peek(i).getRoute().getTime(2)-destLanes.get(0).peek(i).getRoute().getTime(0);
            System.out.println(stat1);
            stat2 = stat2+stat1;
        }
        stat2/=5;
        System.out.println("The Average of the Five Most Recent cars is: "+stat2);
        
    }

}