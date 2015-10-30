package edu.cccnj.FivePoints.Components;
import edu.cccnj.FivePoints.General.Actor;
import edu.cccnj.FivePoints.General.Queue;

import java.util.ArrayList;
/**
 * Write a description of class Stats here.
 *
 * @author (Nancy, Jamie)
 * @version (Awesome Version 10.6.15)
 */
public class Stats implements Actor
{
    /** All of the lanes in the simulation */
    private ArrayList<Lane> dest;

    /**
     * Constructor for objects of class Stats. Sets the Lanes.
     */
    public Stats(ArrayList<Lane> destLanes)
    {
        dest = destLanes;
    }

    /**
     * Act. Every certain amount of ticks run Stats methods.
     * @param time
     */
    public void act(int time)
    {
        if(time % 5 ==0) {
            currentCount(time);
            getMaxTraversal();
            getMinTraversal();
        }
    }

    /**
     * Find out the average time for a car to make it
     * through all of the lanes.
     * @param time The current time in ticks
     */
    public void currentCount(int time){
        double total=0;

        for(Lane queue: dest)
            total=total+queue.size();

        System.out.println("The average time per car is: "+ total/time);
    }

    /**
     * Get the maximum traversal time. That is,
     * the highest amount of any car through all lanes.
     */
    public void getMaxTraversal(){
        int max = 0;
        int crtime =0;

        for(Lane a: dest){
            Queue<Car> cars = a.getQueue();

            for(int i =0;i<a.size(); i++){
                Car c= a.peek(i);
                Route r=c.getRoute();
                //dest lanes should always be null
                if (r.getNextLane()==null){
                    int startime= r.getTime(0);
                    int finishtime= r.getTime(2);
                    if(max<(finishtime-startime)){

                        max =(finishtime-startime);
                        crtime=startime;
                    }

                }

            }
        }
        System.out.println("The maximum traversal time is: "+ max +". The car was created at time: "+crtime);
    }

    /**
     * Get the minimum traversal time. That is,
     * the lowest amount of time of any car through all lanes.
     */
    public void getMinTraversal(){
        int min = 100; //arbitrary number
        int crtime =0;
        for(Lane a: dest){
            Queue<Car> cars = a.getQueue();

            for(int i =0;i<a.size(); i++){
                Car c= a.peek(i);
                Route r=c.getRoute();
                if (r.getNextLane()==null){
                    int startime= r.getTime(0);
                    int finishtime= r.getTime(2);
                    //dest lane should always be null
                    if(min>(finishtime-startime)){

                        min =(finishtime-startime);
                        crtime=startime;
                    }

                }

            }
        }
        System.out.println("The minimum traversal time is: "+ min +".  The car was created at time: "+crtime);

    }

    public int getQueueSize()
    {

        return -1; // TODO: not this
    }

}