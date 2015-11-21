package FivePoints.Threading;

import FivePoints.General.Pair;

import java.util.concurrent.Semaphore;
import java.util.function.Consumer;

/**
 * Performer assists in acquiring a semaphore
 * and performing an action on it.
 */
public class Performer {

    /**
     * Perform an operation on a semaphore-locked piece of data. The semaphore should be free unless another
     * Performer.perform() is running on it.
     * @param shared The semaphore and the data which it protects.
     * @param function The function (void funct(T)) that will operate on the data
     * @param <T> Whatever kind of data you're working with
     */
    public synchronized static <T> void perform(Pair<Semaphore, T> shared, Consumer<T> function){
        try {
            // Acquire lease on mutex
            shared.getItem1().acquire();

            // Perform operation on data
            function.accept(shared.getItem2());

            // Release mutex
            shared.getItem1().release();
        } catch(InterruptedException e){
            /* Deliberately do nothing - the mutex is locked */
        }
    }

}
