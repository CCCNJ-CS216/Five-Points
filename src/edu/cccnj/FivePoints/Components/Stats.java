package edu.cccnj.FivePoints.Components;

import edu.cccnj.FivePoints.General.Actor;

import java.util.ArrayList;
/**
 * Write a description of class Stats here.
 *
 * @author (Nancy, Jamie)
 * @version (Awesome Version10.6.15)
 */
public class Stats implements Actor
{
    private ArrayList<Lane> dest;
     public Route croute;

    /**
     * Constructor for objects of class Stats
     */
    public Stats(ArrayList<Lane> destLanes)
    {
        dest = destLanes;
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
        for(Lane queue: dest){
            total=total+queue.size();

        }
        System.out.println("the average time per car is:"+ total/time);
    }
    /*gets maximum traversal time and displays when it that object was created
    public void getMaxTraversal(){
     
        for(Lane a: dest){
         a.getQueue();
           
        }
        
    }
     //gets minimum traversal time and displays when it that object was created
    public void getMinTraversal(){
        
        
        
    }
    */
    public int getQueueSize()
    {

        return -1; // TODO: not this
    }

}