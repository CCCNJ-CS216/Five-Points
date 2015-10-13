package edu.cccnj.FivePoints;

import edu.cccnj.FivePoints.General.Actor;
import edu.cccnj.FivePoints.General.Stack;
import edu.cccnj.FivePoints.World.Controller;
/*import edu.cccnj.FivePoints.World.GraphNavigation.CoordinateMap;
import edu.cccnj.FivePoints.World.GraphNavigation.MapObject;
import edu.cccnj.FivePoints.World.GraphNavigation.Node;*/
import edu.cccnj.FivePoints.General.TickManager;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The entry point for the Five-points program. Begins the main controller.
 */
public class Main {

        /**
     * Before the sekeleton is fully written, main is going to test (poorly) and demonstrate
     * the ability of implemented objects. Come here as a tutorial
     * @param args
     */
    public static void main(String[] args){
        // Make a new controller and start it
        new Controller(1).run(9);
    }

}

