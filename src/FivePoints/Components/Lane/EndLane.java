/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FivePoints.Components.Lane;

import FivePoints.Simulation.World;

/**
 *
 * @author jd001
 */
public class EndLane extends Lane {

    /**
     *
     * @param world
     * @param xpos
     * @param ypos
     */
    public EndLane(World world, int xpos, int ypos) {
        super(world, xpos, ypos);
    }

    @Override
    public void Snap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        if (!carCells.getFirst().isEmpty()) {
            if (carCells.getFirst().vehicle.isReady()) {
                //PROBLEM: cant add the dead cars to the dead ators list so i ust permenmently remove them
                carCells.getFirst().remove();
            }
        }
        updateCars();
    }

    @Override
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
