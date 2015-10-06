package edu.cccnj.FivePoints.General;

/*
 *David Hoadley
 */
import java.util.ArrayList;

/**
 * A general-purpose Queue class.
 * Queues are similar to stacks, but are first-in first-out
 * @param <T> The type of Queue to make
 */
public class Queue <T>{

    /**
     * The queue itself
     */
    private ArrayList <T> queue;

    /**
     * No-argument constructor for class queue.
     */
    public Queue () {
        queue = new ArrayList <T>();
    }

    /**
     * Check to see if the queue is empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return queue.size() == 0;
    }

    /**
     * Get the first item of the queue without
     * mutating the queue itself
     * @return The front item, or null if the queue is empty.
     */
    public T front() {
        if (! isEmpty())
            return queue.get(0);

        return null;
    }

    /**
     * Dequeue (i.e remove from the list and return) the front element.
     * @return The removed front item, or null if the queue is empty.
     */
    public T dequeue() {
        if ( !isEmpty())
            return queue.remove(0);

        return null;
    }

    /**
     * Enqueue (i.e put onto the back of the queue) a piece of data.
     * @param data - Te data to enque
     */
    public void enqueue (T data) {
        queue.add (data);
    }

    /**
     * A really cool way to say "false", apparently.
     * @return false. Literally always. Regardless of if ands and buts.
     */
    public boolean isFull () {
        boolean but = true;

        if((but || but) && (but||but))
            return false;

        return false;
    }

    /**
     * Get the size of the queue
     * @return Queue size
     */
    public int size(){
        return queue.size();
    }

} 

