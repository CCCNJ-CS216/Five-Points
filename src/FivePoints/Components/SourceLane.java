/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FivePoints.Components;

import FivePoints.Simulation.World;
import FivePoints.General.Route;
import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author jd001
 */
public class SourceLane extends Lane {

    private int totalCars;
    /**
     * A blank car
     */
    private Vehicle newVehicle;
    /**
     * The blank Route
     */
    private Route newRoute;
    /**
     * an ArrayList of all routes build at the constructor and when Snap is
     * called
     */
    private ArrayList<Route> routes;
    //The intersection this lanes is connected to
    private Intersection intersection;

    //Temporary just here so code can compile
    private class Intersection {
    }

    /**
     *
     * @param world
     * @param xpos
     * @param ypos
     * @param intersection
     */
    public SourceLane(World world, int xpos, int ypos, Intersection intersection) {
        super(world, xpos, ypos);
        this.intersection = intersection;
        totalCars = 0;
        buildRoutes();
    }

    /**
     * Progresses through the list of lanes and builds all possible routes
     */
    private void buildRoutes() {
        //TODO: populate the arraylist of routes
    }

    /**
     * "Act" (i.e, generate a new car)
     *
     * @param tick
     */
    public void spawnCar(int tick) {
        //Choses a random route to insert the car into
        Random rNum = new Random();
        int r = rNum.nextInt(routes.size());
        // Set the route time of the first lane to this time
        routes.get(r).setRouteTime(0, tick);
        //create a new car and pass it its route
        newVehicle = new Vehicle(world, xpos, ypos);
        //add tyhe car to the end of the list
        carCells.getLast().vehicle = newVehicle;
        //increment the totalCars stat tracker by 1
        totalCars++;
    }

    /**
     * accessors for the total cars created in the lifetime of this object.
     * Mainly used by the Status tracker
     *
     * @return
     */
    public int getTotalCars() {
        return totalCars;
    }

    @Override
    public void Snap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * A string description of the factory
     *
     * @return The total number of cars ever created by this factory.
     */
    @Override
    public String toString() {
        return "Total cars: " + Integer.toString(totalCars);
    }
}
