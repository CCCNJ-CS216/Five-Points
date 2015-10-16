

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
        // Make a new controller that ticks every millisecond and run it 9 times
        new Controller(1).run(9);
    }

}

