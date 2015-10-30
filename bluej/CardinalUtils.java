

/**
 * Helper functions for dealing with the compass.
 */
public abstract class CardinalUtils {

    /**
     * Get the opposite direction of the specified one
     * @param direction The original direction
     * @return The opposite direction of original
     */
    public static Cardinal getOpposite(Cardinal direction){
        switch (direction){
            case NORTH:
                return Cardinal.SOUTH;
            case SOUTH:
                return Cardinal.NORTH;
            case EAST:
                return Cardinal.WEST;
            case WEST:
                return Cardinal.EAST;
        }

        return null;
    }

    /**
     * Get the adjacent direction in a clockwise fashion.
     * @param direction The direction to find the adjecent Cardinal to
     * @return The adjacent direction
     */
    public static Cardinal getClockwiseAdjacent(Cardinal direction){
        switch(direction){
            case NORTH:
                return Cardinal.EAST;
            case EAST:
                return Cardinal.SOUTH;
            case SOUTH:
                return Cardinal.WEST;
            case WEST:
                return Cardinal.NORTH;
        }
        return null;
    }


    /**
     * Turn a cardinal direction into a relative one
     * @param direction The direction to use
     * @return Up if north, Right if east, etc.
     */
    public static Direction toDirection(Cardinal direction){
        switch(direction){
            case NORTH:
                return Direction.UP;
            case EAST:
                return Direction.RIGHT;
            case SOUTH:
                return Direction.DOWN;
            case WEST:
                return Direction.LEFT;
        }
        return null;
    }

    /**
     * Turn a direction into a cardinal direction
     * @param direction The direction to use
     * @return North if up, Right if east, etc.
     */
    public static Cardinal toCardinal(Direction direction){
        switch(direction){
            case UP:
                return Cardinal.NORTH;
            case DOWN:
                return Cardinal.SOUTH;
            case RIGHT:
                return Cardinal.EAST;
            case LEFT:
                return Cardinal.WEST;
        }
        return null;
    }
}
