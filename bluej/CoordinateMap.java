
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;


/**
 * CoordinateMap manages a set of nodes that are either occupied or free.
 * When moving a whole object, the translation must only occupy blocks which
 * are free, or else the translation refuses to execute.
 */
public class CoordinateMap {

    /**
     * Structure representing the running world.
     */
    private ArrayList<ArrayList<Node>> map = new ArrayList<ArrayList<Node>>();

    /**
     * A list of active MapObjects.
     */
    private ArrayList<MapObject> activeObjects = new ArrayList<>();

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
            // Initialize a new column at (x,_)
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
        activeObjects.add(item);

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
     * Empties the coordinate map, keeping the dimmensions.
     */
    public void clearCoordinateMap(){
        activeObjects.clear();
        for(int a = 0; a < map.size(); a++){
            for(int b = 0; b < map.get(0).size(); b++){
                map.get(a).remove(b);
                map.get(a).add(b, Node.Empty);
            }
        }
    }

    /**
     * Gets references to the MapObjects that are in conflict (i.e, overlapping)
     * with one another so that the controller can remove them (accident?)
     * @return a list of conflicting objects
     */
    public ArrayList<Pair<MapObject, MapObject>> getConflicting(){
        ArrayList<Pair<MapObject, MapObject>> conflicting = new ArrayList<>();

        for(MapObject toTest: activeObjects){
            for(MapObject testAgainst: activeObjects){
                // Pass by the same object
                if(toTest == testAgainst)
                    continue;

                if(toTest.conflicts(testAgainst))
                    conflicting.add(new Pair<>(toTest, testAgainst));
            }
        }

        return conflicting;
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

                if(currentNode == Node.Car)
                    s += "c";
                else if(currentNode == Node.Empty)
                    s += "e";
                else if(currentNode == Node.Lane)
                    s += "l";
                else if(currentNode == Node.Object)
                    s += "o";
            }
            s += "\n";
        }
        return s;
    }

    /**
     * Move the MapObject a certain amount, based on the pair.
     * X value is the amount on the X axis, y value is the amount on the Y axis.
     * @param type - The type of the objects to get.
     */
    public ArrayList<MapObject> getMapObjects(Node type) {
        return new ArrayList(Arrays.asList(activeObjects.stream().filter(m -> m.type == type).toArray()));
    }
}
