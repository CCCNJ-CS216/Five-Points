

import java.util.ArrayList;

/**
 * As with real traffic lights, a LightPost itself is
 * made up of 4 synchronized faces.
 */
public class LightPost {

    // Up, Right.
    private TrafficLight northFace;
    private TrafficLight eastFace;

    // Down, Left.
    private TrafficLight southFace;
    private TrafficLight westFace;

    // Binding of synced panels.
    private ArrayList<SynchronizedPanel> syncedPanels = new ArrayList<>();

    /**
     * Creates a new LightPost.
     *
     * @param greenTime  How long any given TrafficLight will be green for.
     * @param redTime    How long any given TrafficLight will be red for.
     * @param yellowTime How long any given TrafficLight will be yellow for.
     * @param firstGreen The direction which should be green first
     *                   Note: (North and South) and (East and West) have the same effect.
     */
    public LightPost(int greenTime, int redTime, int yellowTime, Cardinal firstGreen) {

        // Initialize the traffic lights
        northFace = new TrafficLight(greenTime, redTime, yellowTime, LightColor.RED);
        southFace = new TrafficLight(greenTime, redTime, yellowTime, LightColor.RED);
        eastFace  = new TrafficLight(greenTime, redTime, yellowTime, LightColor.RED);
        westFace  = new TrafficLight(greenTime, redTime, yellowTime, LightColor.RED);

        // Initialize the synced panels
        syncedPanels.add(new SynchronizedPanel(northFace, southFace));
        syncedPanels.add(new SynchronizedPanel(eastFace, westFace));

        getPanel(firstGreen).force(LightColor.GREEN);
        getPanel(CardinalUtils.getClockwiseAdjacent(firstGreen)).force(LightColor.RED);

    }

    /**
     * Get the traffic light facing a given direction from the perspective
     * of the post.
     *
     * @param direction The direction to retrieve.
     * @return The face pointing in this direction.
     */
    public TrafficLight getFace(Cardinal direction) {
        switch (direction) {
            case NORTH:
                return northFace;
            case SOUTH:
                return southFace;
            case EAST:
                return eastFace;
            case WEST:
                return westFace;
        }

        // Should never happen
        return null;
    }


    /**
     * Get the entire synchronized panel for a given direction.
     *
     * @param direction The direction which the panels control
     * @return The panel
     */
    public SynchronizedPanel getPanel(Cardinal direction) {
        for (SynchronizedPanel panel : syncedPanels)
            if (panel.has(getFace(direction)))
                return panel;

        return null;
    }

    @Override
    public String toString(){
        return "North: " + northFace.toString() +
                "South: " + southFace.toString() +
                "East: " + eastFace.toString() +
                "West: " + westFace.toString();
    }

    /**
     * Act. This will cause each synchronized face to act.
     * @param ticks The current tick count of the simulation.
     */
    public void act(int ticks){
        for(SynchronizedPanel panel : syncedPanels)
            panel.act(ticks);
    }
}
