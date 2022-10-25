package it.unibo.collections;

import java.util.List;
import java.util.Map;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        final int START = 1000;
        final int FINISH = 2000;
        final int TEST = 100_000;        
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final List<Integer> l1 = new ArrayList<>();
        for (int i = START; i < FINISH; i++) {
            l1.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final List<Integer> l2 = new LinkedList<>(l1);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final int temp = l1.get(0);
        l1.set(0, l1.get(l1.size - 1));
        l1.set(l1.size - 1, (Integer)temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer i : l1) {
            System.out.println(i);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        testPerformance(TEST, l1, true);
        testPerformance(TEST, l2, false);
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        /*
         * 8) Compute the population of the world
         */
    }

    private void testPerformance(final int ELEMS, List list, final boolean isArrayList) {
        /*
         * Prepare a variable for measuring time
         */
        long time = System.nanoTime();
        /*
         * Run the benchmark
         */
        for (int i = 1; i <= ELEMS; i++) {
            list.add(i);
        }
        /*
         * Compute the time and print result
         */
        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Converting "
                + ELEMS
                + " ints to Integer and inserting them in a "
                + (isArrayList ? "Array" : "Linked")
                + "List took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
    }
}
