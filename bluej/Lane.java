
import java.util.ArrayList;

/** 
 * @author (Reno Levari)
 * @version (9/15/15)
 */

public class Lane
{
    TrafficLight trafficLight;
    Queue<Car> queue;
    int maxcount;
    private ArrayList<Car> cars;

    public Lane(TrafficLight trafficLight, Queue queue, int maxcount)
    {
        this.trafficLight = trafficLight;
        this.queue = queue;
        this.maxcount = maxcount;
        cars = new ArrayList<>();
    }
    
    public void addCar(Car c)
    {
        cars.add(c); 
    }
    
    public void removeCar(Car c)
    {
       cars.remove(c);  //will remove car from queue
    }

    public TrafficLight getTrafficLight()
    {
        return trafficLight;
    }

    public Queue getQueue()
    {
        return queue;
    }

    public void setTrafficLight(TrafficLight trafficLight)
    {
        this.trafficLight = trafficLight;
    }

    public void setQueue(Queue queue)
    {
        this.queue = queue;
    }

    public int getMaxCount()
    {
        return maxcount;
    }

    public void setMaxCount(int maxcount)
    {
        this.maxcount = maxcount;
    }

    public int getQueueSize()
    {
        return queue.size();
    }
}