 

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Pair is a general purpose class for coupling together
 * two objects of different or same type. (Java doesn't have tupples??)
 */
public class Pair<T1, T2> {
    /**
     * The first item of the tuple
     */
    protected T1 item1;

    /**
     * The second item of the tuple.
     */
    protected T2 item2;

    public Pair(T1 item1, T2 item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    /**
     * Test to see if this pair has a value equal to that of another
     *
     * @param otherPair - The pair to compare
     */
    public boolean equals(Pair otherPair) {
        return this.item1 == otherPair.item1 && this.item2 == otherPair.item2;
    }

    /**
     * Convert the Pair to a String representation.
     *
     * @return The Pair as a string.
     */
    public String toString() {
        return "item1: " + item1.toString() + " | item2: " + item2.toString();
    }

    /**
     * Zip together two arrays to create a list of pairs. A mismatch in size will trucate.
     *
     * @param array1 - The first array (x)
     * @param array2 - The second array (y)
     * @param <T1>   - The type of the first array
     * @param <T2>   - The type of the second array
     * @return The arrays zipped together
     */
    public static <T1, T2> ArrayList<Pair<T1, T2>> zip(T1[] array1, T2[] array2) {
        ArrayList<Pair<T1, T2>> pairs = new ArrayList<>();

        // Iterate over the first list
        for (int i = 0; i < array1.length && i < array2.length; i++) {
            // Bind it to the second array
            pairs.add(new Pair<T1, T2>(array1[i], array2[i]));
        }

        return pairs;
    }


    /**
     * Lookup the value associated with the identifier.
     * All of the matching values are returned
     *
     * @param table - The table to look the value up in
     * @param item  - The item to search by
     * @param <T1>  - The type of the first item for the pairs
     * @param <T2>  - The type of the second item for the pairs
     * @return The values associated with item
     */
    public static <T1, T2> ArrayList<T2> lookup(Pair<T1, T2>[] table, T1 item) {
        ArrayList<T2> values = new ArrayList<>();

        for (Pair pair : table) {
            if (pair.item1 == item)
                values.add((T2) pair.item2);
        }

        return values;
    }

}
