

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

