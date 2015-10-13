
import java.util.ArrayList;

/**
 * Skeleton controller!!!
 *     adapted (Hacked!) from Nate's
 * 
 * @author (sbw) 
 * @version (a version number or a date)
 */
public class ControlLite
{

    /**
     * The main loop of the program.
     *
     * Creates a list of Actors,...and makes them .act();
     */

    /**
     * The Actors which control the interaction with the world.
     */
    private ArrayList<Actor> actors = new ArrayList<>();

    public ControlLite()
    {}

    /**
     * Run the controller  -- START SIMULATION *HERE*
     */
    public void run()
    {
        //try {
            initialize();  //create the actors

            //sbw temp
            for(int tick=1; tick< 9; tick++)  //sbw 10/7 - bombs out at 5th 
            {
                System.out.println("Tick="+tick);//sbw test
                for(Actor a : actors){
                    a.act(tick);
                    System.out.println("Just acted on " + a.toString());
                }
            }

      //  } catch(Exception e){
            //System.out.println("Something has gone horribly wrong.");// , but we're going to try again anyway.");
            //this.run();   //sbw - good recovery but disabled for faster debugging
       // }
    }

    /**
     * Initialize the controller with 3 Lanes, a CarSource, and a TrafflicLight
     */
    //sbw added Stats
    public void initialize()
    {
        TrafficLight light = new TrafficLight();//sbw consider using 3-param constructor
        Lane lane1 = new Lane(light, 99);//TODO: No arbitrary maxcount
        Lane lane2 = new Lane(light, 99);//TODO: No arbitrary maxcount
        Lane lane3 = new Lane(light, 99);//TODO: No arbitrary maxcount
        ArrayList<Lane> dests = new ArrayList();  //sbw
        dests.add(lane3);  //sbw
        Stats statx = new Stats( dests );   //sbw
        CarSource source = new CarSource(this, lane1, lane2, lane3);

        Actor[] initialActors = {light, lane1, lane2, lane3, source, statx};  //sbw

        // Add all the actors to the controller    
        for(Actor a: initialActors)
            actors.add(a);
        //this.addActor( a, 1);     

    }
}
