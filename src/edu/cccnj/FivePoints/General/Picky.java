package edu.cccnj.FivePoints.General;

/**
 * Picky is a class for objects
 * that would prefer to tell the controller
 * that they determine their own cycle time, regardless
 * of what their tick managers say.
 */
public abstract class Picky {
    /**
     * The cycle time to specify to the controller.
     */
    private int cycleTime;

    /**
     * Get the current cycle time of the Picky Object
     * @return The current cycle time
     */
    public int getCycleTime(){
        return this.cycleTime;
    }

    /**
     * Tell the Picky object to use a new time as its
     * cycle time
     * @param newTime The time to use on the Object.
     */
    public void setCycleTime(int newTime){
        this.cycleTime = newTime;
    }
}
