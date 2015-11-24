/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FivePoints.Components;

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

    protected void updateCars() {
        for (Box box : carCells) {
            if (!box.isEmpty()) {
                box.vehicle.update();
                box.vehicle.draw();
            }
        }
    }

    private class Box {

        private Vehicle vehicle;

        private Box() {}

        private boolean isEmpty() {
            return vehicle == null;
        }

    }
}
