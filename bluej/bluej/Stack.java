
/**
 * Stack Class:
 *
 * The Stack class is a generic collection class (first-in, last-out).
 * to instantiate a new Stack of type, say, Car, the syntax would be
 *
 * Stack<Car> cars = new Stack<>();
 * @author Josue Gomez
 * @version 1.1
 */

import java.util.ArrayList;

public class Stack<T>
{
    /**
     * The stack itself.
     */
    private ArrayList<T> stack = new ArrayList<>();

    /**
     * The constructor for class Stack.
     */
    public Stack()
    {

    }

    /**
     * Removes an element from the end of the Array List.
     */
    public T pop()
    {
        return stack.remove(stack.size() - 1);
    }

    /**
     * Push a new Item onto the stack
     * @param item - The item to push
     */
    public void push(T item)
    {
        stack.add(item);
    }

    /**
     * Returns the number of vehicles in the collection.
     */
    public int size()
    {
        return stack.size();
    }

}