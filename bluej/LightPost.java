

import java.util.ArrayList;

/**
 * As with real traffic lights, a LightPost itself is
 * made up of 4 synchronized faces.
 */
public class LightPost implements Actor {

    // Up, Right.
    private TrafficLight northFace;
    private TrafficLight eastFace;

    // Down, Left.
    private TrafficLight southFace;
    private TrafficLight westFace;

    // Binding of synced panels.
    private ArrayList<SynchronizedPanel> syncedPanels = new ArrayList<>();

    private Cardinal currentGreen;

    /**
     * Creates a new LightPost.
     *
     * @param northSouth How configuration for the north and south lights.
     * @param eastWest How the configuration for the east and west lights.
     * @param firstGreen The direction which should be green first
     *
     */
    public LightPost(LightConfiguration northSouth, LightConfiguration eastWest, Cardinal firstGreen) {

        // Initialize the traffic lights
        northFace = new TrafficLight(northSouth.getGreenTime(),
                northSouth.getRedTime(), northSouth.getYellowTime(), LightColor.RED);

        southFace = new TrafficLight(northSouth.getGreenTime(),
                northSouth.getRedTime(), northSouth.getYellowTime(), LightColor.RED);

        eastFace = new TrafficLight(eastWest.getGreenTime(),
                eastWest.getRedTime(), eastWest.getYellowTime(), LightColor.RED);

        westFace = new TrafficLight(eastWest.getGreenTime(),
                eastWest.getRedTime(), eastWest.getYellowTime(), LightColor.RED);

        // Initialize the synced panels
        syncedPanels.add(new SynchronizedPanel(northFace, southFace));
        syncedPanels.add(new SynchronizedPanel(eastFace, westFace));

        getPanel(firstGreen).force(LightColor.GREEN);
        getPanel(CardinalUtils.getClockwiseAdjacent(firstGreen)).force(LightColor.RED);

        currentGreen = firstGreen;

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
     * Run. This will.
     */
    public void act (int ticks) {
        try {
            SynchronizedPanel panel = getPanel(currentGreen);

            panel.act(ticks);

            // Is the primary light red? Time to shift our focus then.
            if(panel.getCurrentColor() == LightColor.RED) {
                currentGreen = CardinalUtils.getClockwiseAdjacent(currentGreen);
                getPanel(currentGreen).force(LightColor.GREEN);
            }

        } catch(Exception e){
            System.out.println("SYNC ERROR IN LIGHTPOST OBJECT: " + super.toString());
        }
    }
}
