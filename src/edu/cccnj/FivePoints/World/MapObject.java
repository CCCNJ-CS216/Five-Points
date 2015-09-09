package edu.cccnj.FivePoints.World;

/**
 * MapObject is a wrapper-ish class for maintaining an object with
 * definite length and a category defined by World.Node.
 *
 * Used internally by the controller.
 */
public class MapObject {
    /**
     * What kind of object it is.
     */
    protected Node type;

    protected int x1, x2;
    protected int y1, y2;

    /**
     * Construct a new MapObject given the specified coordinate points.
     * @param type The type (World.Node) of MapObject to be created.
     * @param x1 The x coordinate for the bottom left point.
     * @param x2 The x coordinate for the bottom right point.
     * @param y1 The y coordinate for the top left point.
     * @param y2 The y coordinate for the top right point.
     */
    public MapObject(Node type, int x1, int x2, int y1, int y2) {

        // Check coordinate sanity
        this.checkCoordinates(x1, x2, y1, y2);

        this.type = type;

        this.x1 = x1;
        this.x2 = x2;

        this.y1 = y1;
        this.y2 = y2;

    }

    /**
     * Gets the quantity representing the length of the object (x-axis)
     * @return the length
     */
    public int getLength(){
        return x2 - x1;
    }

    /**
     * Returns the quantity representing the height of the object (y-axis)
     * @return the height
     */
    public int getHeight(){
        return y2 - y1;
    }


    /**
     * Translates the mapObject a given distance.
     * @param xOffset The amount to translate on the x Axis.
     * @param yOffset The amount to translate n the y Axis.
     * @throws Exception if either offset brings their respective value below 0
     */
    public void translate(int xOffset, int yOffset) {
        this.x1 += xOffset;
        this.x2 += xOffset;

        this.y1 += yOffset;
        this.y2 += yOffset;

        this.checkCoordinates();
    }

    /**
     * Grow the object by given magnitudes.
     * @param factor How much to grow
     * @param direction In which direction to grow the object
     */
    public void grow(int factor, Direction direction){
        if(direction == Direction.Left)
            this.x1 -= factor;
        else if(direction == Direction.Right)
            this.x2 += factor;
        else if(direction == Direction.Up)
            this.y2 += factor;
        else if(direction == Direction.Down)
            this.y1 -= factor;

        this.checkCoordinates();
    }

    /* INTERNAL CLASS CHECKS */

    /**
     * Internal check for sane Coordinates.
     * @param x1 -  Left x
     * @param x2 -  Right x
     * @param y1 - Bottom y
     * @param y2 - Top y
     * @throws Exception if the second coordinate is less than the first, or less than 0
     */
    private static void checkCoordinates(int x1, int x2, int y1, int y2){
        try {
            if (x2 <= x1 || y2 <= y1)
                throw new Exception("Second bounding coordinate does not exceed first." +
                        "\nx1: " + x1 +
                        "\nx2: " + x2 +
                        "\ny1: " + y1 +
                        "\ny2: " + y2);
            if(x1 < 0 || x2 < 0 || y1 < 0 || y2 < 0)
                throw new Exception("Coordinate less than 0" +
                        "\nx1: " + x1 +
                        "\nx2: " + x2 +
                        "\ny1: " + y1 +
                        "\ny2: " + y2);
        } catch(Exception e) {
            e.printStackTrace(); // TODO: Add throws clause and handle in the controller.
        }
    }

    /**
     * Check the coordinates of the current object.
     * @throws Exception if the second coordinate is less than the first, or less than 0
     */
    private void checkCoordinates(){
        this.checkCoordinates(this.x1, this.x2, this.y1, this.y2);
    }
}
