/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FivePoints.Components;

import FivePoints.Simulation.World;

/**
 *
 * @author jd001
 */
public class SourceLane extends Lane{

    /**
     *
     * @param world
     * @param xpos
     * @param ypos
     */
    public SourceLane(World world, int xpos, int ypos) {
        super(world, xpos, ypos);
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
    
}
