package FivePoints.Threading;

import FivePoints.General.Pair;

import java.util.concurrent.Semaphore;
import java.util.function.Consumer;

/**
 * Represents an object that is thread-protected by a
 * mutex
 * @author nate
 */
public class Shared<T> {
    private Pair<Semaphore, T> internal;

    /**
     * Creates a new Shared structure with the given type
     * @param item
     */
    public Shared(T item){
        internal = buildShared(item);
    }

    /**
     * Perform a function on a Shared piece of data, while listening to the mutex.
     * @param function The function to perform on the piece of shared data
     */
    public void perform(Consumer<T> function){
        Performer.perform(internal, function);
    }

    /**
     * Safely return the data from within the Shared structure
     * @return A pair of this share'd data's semaphore and the data
     */
    public Pair<Semaphore, T> getShared(){
        return internal;
    }

    /**
     * Unsafely return the data from within the shared structure.
     * Only do this if you are sure that the data will never be modified
     * outside of the thread that is accepting this data
     * @return The data, ignoring the semaphore.
     */
    public T getSharedUnsafe(){
        return internal.getItem2();
    }

    /**
     * Bind a mutex to the data and return it
     * @param data The data to bind a mutex with
     * @param <T> The type of data being worked with
     * @return The new structure
     */
    public static <T> Pair<Semaphore, T> buildShared(T data) {
        return new Pair(new Semaphore(1), data);
    }

}
