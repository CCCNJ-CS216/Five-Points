package FivePoints.GraphNavigation;

/**
 * The node is the basic building block of the CoordinateMap.
 * It contains information useful for identifying the type
 * of terrain a Node is, and serves as a Wrapper class for
 * CoordinateMap's internal ArrayList.
 */
public enum Node {
    Empty,
    Lane,
    Car,
    Object
}
