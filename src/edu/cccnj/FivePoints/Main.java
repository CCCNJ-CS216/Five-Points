package edu.cccnj.FivePoints;

import edu.cccnj.FivePoints.Components.Light.LightColor;
import edu.cccnj.FivePoints.Components.Light.LightConfiguration;
import edu.cccnj.FivePoints.Components.Light.LightPost;
import edu.cccnj.FivePoints.Components.Light.TrafficLight;
import edu.cccnj.FivePoints.General.*;
import edu.cccnj.FivePoints.World.Controller;
/*import edu.cccnj.FivePoints.World.GraphNavigation.CoordinateMap;
import edu.cccnj.FivePoints.World.GraphNavigation.MapObject;
import edu.cccnj.FivePoints.World.GraphNavigation.Node;*/
import edu.cccnj.FivePoints.World.GraphNavigation.Direction;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The entry point for the Five-points program. Begins the main controller.
 */
public class Main {

    /**
     * Simply creates a new Controller and runs it
     * @param args Any command line arguments. Currently ignored.
     */
    public static void main(String[] args){

        LightPost post = new LightPost(new LightConfiguration(3, 4, 2),
                new LightConfiguration(1, 2, 3), Cardinal.NORTH);

        for(int i = 0; i < 100; i++){
            post.act(i);
            System.out.println(post.toString());
        }
        //new Controller(1).run(9);
    }
}

