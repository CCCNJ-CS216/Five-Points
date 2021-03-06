/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FivePoints.Components.Lane;

import FivePoints.Components.Intersection.Intersection;
import FivePoints.Components.Vehicle.Route;
import FivePoints.Components.Vehicle.Vehicle;
import FivePoints.Simulation.World;
import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author jd001
 */
public class SourceLane extends Lane {

    private int spawnRate;

    private int totalCars;
    /**
     * A blank car
     */
    private Vehicle newVehicle;
    /**
     * /**
     * an ArrayList of all routes build at the constructor and when Snap is
     * called
     */
    private ArrayList<Route> routes;
    //The intersection this lanes is connected to
    private Intersection intersection;

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
        this.spawnRate = 3;
        buildRoutes();
    }

    /**
     *
     * @param world
     * @param xpos
     * @param ypos
     * @param intersection
     * @param spawnRate
     */
    public SourceLane(World world, int xpos, int ypos, Intersection intersection, int spawnRate) {
        super(world, xpos, ypos);
        this.intersection = intersection;
        totalCars = 0;
        this.spawnRate = spawnRate;
        buildRoutes();
    }

    /**
     * Progresses through the list of lanes and builds all possible routes
     */
    private void buildRoutes() {
        routes = new ArrayList();
        Route newRoute = new Route();
        //TODO: populate the arraylist of routes
        newRoute.addStep(this);
        //Add the rest of the route here
        routes.add(newRoute);
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
        if (carCells.getLast().isEmpty()) {
            Random rand = new Random();
            if (rand.nextInt(spawnRate) == 0) {
                //PROBLEM: NO more global time tracking acessable from here
                this.spawnCar(0);
            }
        }
        //PROBLEM: Lanes can not see their Traffic Lights OR give them cars
        if (/*THe light is green*/false) {
            if (!carCells.getFirst().isEmpty() && carCells.getFirst().vehicle.isReady()) {
                carCells.getFirst().remove();
            }
        }
        updateCars();
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
