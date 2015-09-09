package edu.cccnj.FivePoints.World;

import java.util.ArrayList;

/**
 * CoordinateMap manages a set of nodes that are either occupied or free.
 * When moving a whole object, the translation must only occupy blocks which
 * are free, or else the translation refuses to execute.
 */
public class CoordinateMap {

    /**
     * Structure representing the running world.
     */
    private ArrayList<ArrayList<Node>> map;


    /**
     * Create and initialize a new CoordinateMap given a square size.
     * @param sizeX - The size of the square on the x Axis
     * @param sizeY - The size of the square on the y Axis
     */
    public CoordinateMap(int sizeX, int sizeY){
        // Initialize collection
        map = new ArrayList<ArrayList<Node>>();

        // Iterate across x's
        for(int a = 0; a < sizeX; a++) {
            // Initialize a new colum at (x,_)
            map.add(new ArrayList<Node>());

            // Populate column with Empty nodes
            for(int b = 0; b < sizeY; b++)
                map.get(a).add(Node.Empty);

        }
    }

    /**
     * Insert a map object onto the map, regardless of any clashes
     * with existing Nodes or bounding areas.
     * @param item - The mapObject to insert
     */
    public void insertMapObject(MapObject item){
        for(int a = item.x1 - 1; a < item.x2; a++){
            for(int b = item.y1; b < item.y2; b++){
                // Remove the old value.
                this.map.get(a).remove(b);

                // Insert the new value;
                this.map.get(a).add(b, item.type);
            }
        }
    }

    /**
     * A textual representation of the coordinateMap
     * @return a string model of the map.
     */
    public String toString(){
        String s = new String();
        for(int a = 0; a < map.size(); a++){
            for(int b = 0; b < map.get(a).size(); b++){
                Node currentNode = map.get(a).get(b);

                // TODO: Create final lookup table for this hard-coded values
                if(currentNode == Node.Car)
                    s += "c";
                else if(currentNode == Node.Empty)
                    s += "e";
                else if(currentNode == Node.Lane)
                    s += "l";
            }
            s += "\n";
        }
        return s;
    }

    // TODO: Create ways for the controller to individually move MapObjects
}
