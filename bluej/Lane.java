

import java.util.ArrayList;

/** 
 * @author (Reno Levari)
 * @version (9/15/15)
 */

public class Lane implements Actor
{
    TrafficLight trafficLight;
    Queue<Car> cars;
    int maxcount;
    
    // have to pass in null

    public Lane(TrafficLight tLight)
    {
        trafficLight = tLight;
        cars = new Queue<>();
        maxcount = 0; //Infinite lane

    }

    public Lane(TrafficLight tLight, int maxc)
    {
        trafficLight = tLight;  //sbw this!
        cars = new Queue<>();
        maxcount = maxc;

    }

    public Car dequeue()
    {
        return cars.dequeue();  
    }

    public void  enqueue(Car c)
    {   
        if (!this.isFull())
            cars.enqueue(c);
    }
    
    public boolean isFull()
    {
        if ( cars.size() >= maxcount && maxcount  != 0)
        {return true;}
        return false;

    }
    
    public boolean isEmpty()
    { return cars.isEmpty();
    }
    
    
    public Car front()
    {
        return cars.front();
    }
        

    public int size()
    {return cars.size();
    }

    public TrafficLight getTrafficLight()
    {
        return trafficLight;
    }

    public Queue getQueue()
    {
        return cars.clone();
    }

    public void setTrafficLight(TrafficLight tLight)
    {
        trafficLight = tLight;
    }

    public int getMaxCount()
    {
        return maxcount;
    }

    public void act(int tick){  //sbw: must pull front() car
        if(!cars.isEmpty())  //sbw
           cars.front().act(tick);  //sbw
        // xxxxxDo nothing
        System.out.println("Hi there!  I have " + size() +" cars inside.");
    }

    public Car peek(int location){
        return cars.peek(location);
    }
}