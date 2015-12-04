/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FivePoints.Components.Lane;

import FivePoints.Components.Vehicle.Vehicle;
import FivePoints.General.Actor;
import FivePoints.Simulation.World;

import java.util.LinkedList;

/**
 * The functionality shared by all lane types
 *
 * @author Jason Dawson
 */
public abstract class Lane extends Actor {

    /**
     *
     * @author Jason Dawson
     */
    protected LinkedList<Box> carCells;

    /**
     *
     * @param world
     * @param xpos
     * @param ypos
     */
    public Lane(World world, int xpos, int ypos) {
        super(world, xpos, ypos);
        //TODO: Depending on the actual Size of the lane create teh linked list with the appropriate amount of boxes
        //temp just create one of size 3
        createList(3);
    }

    /**
     *
     * @param world
     * @param xpos
     * @param ypos
     * @param size
     */
    public Lane(World world, int xpos, int ypos, int size) {
        super(world, xpos, ypos);
        createList(size);
    }

    /**
     * Create
     *
     * @param size
     */
    protected final void createList(int size) {
        carCells = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            carCells.add(new Box());
        }
    }

    /**
     * The Snap method is called when the lane is placed in the grid. It can
     * also be called when modifications are done to the grid that affect this
     * lane
     *
     * The method sets the location of its carCells in relation to the Grid and
     * gathers any information from the grid necessary to its functioning
     *
     * @author Jason Dawson
     */
    public abstract void Snap();

    /**
     * Updates, draws, and moves cars though the lane However a car at the front
     * of the lane will not be updated
     */
    protected void updateCars() {
        int i = 0;
        for (Box box : carCells) {
            if (!box.isEmpty()) {
                if (1 > 0) {
                    if (carCells.get(i - 1).isEmpty()) {
                        if (carCells.get(i).vehicle.isReady()) {
                            carCells.get(i - 1).vehicle = box.vehicle;
                            box.vehicle = null;
                        }
                        box.vehicle.update();
                    }
                }
                box.vehicle.draw();
            }
            i++;
        }
    }

    /**
     * Check to see if this car can (and should) move lanes.
     *
     * @param ticks The current tick count.
     */
    //    public void act(int ticks)
    //    {
    //        if(currentLane.getTrafficLight() == null)
    //        {
    //            //TODO: might delete itself and/or report stats
    //        }
    //        else if(currentLane.getTrafficLight().getColor() == LightColor.GREEN)
    //        {
    //            Random rgen = new Random();
    //            if(nextLane.getTrafficLight() == null){
    //                changeLane(ticks);
    //            } else if(nextLane.getTrafficLight().getColor() == LightColor.GREEN){
    //                changeLane(ticks);
    //            } else if(nextLane.getTrafficLight().getColor() == LightColor.YELLOW && rgen.nextBoolean()){
    //                changeLane(ticks);
    //            }
    //        }
    //    }
    /**
     * A box that Vehicles can be put into will also contain position
     * information
     */
    protected class Box {

        protected Vehicle vehicle;

        private Box() {
        }

        protected boolean isEmpty() {
            return vehicle == null;
        }

        protected Vehicle remove() {
            Vehicle ret = this.vehicle;
            this.vehicle = null;
            return ret;
        }
    }
}
