package edu.cccnj.FivePoints.General;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Every object of the simulation may eventually be a component.
 */
public abstract class Component implements Actor {
    /**
     * Writes this Component
     * @param out The output stream to write to
     */
    public void writeObject(ObjectOutputStream out){
        try {
            out.writeObject(this);
        } catch(Exception e){
            System.out.println(e.getStackTrace());
        }
    }


    /**
     * Reads this Component
     * @param in The input stream to read from
     */
    public void readObject(ObjectInputStream in){
        try {
            in.defaultReadObject();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
