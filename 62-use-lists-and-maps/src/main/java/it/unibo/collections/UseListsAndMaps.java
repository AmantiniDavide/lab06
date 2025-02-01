package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1000; i < 2000; i++) {
            numbers.add(i);
        }



        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */

        List<Integer> Linkednumbers= new LinkedList<Integer>(numbers);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         * 
         * 
         */
        
        int firstIndex = 0;
        int lastIndex = numbers.size() - 1;
        System.out.println("First element before swap: " + numbers.get(firstIndex));
        System.out.println("Last element before swap: " + numbers.get(lastIndex));

         
        int temp = numbers.get(firstIndex);
        numbers.set(firstIndex, numbers.get(lastIndex));
        numbers.set(lastIndex, temp);

        System.out.println("First element after swap: " + numbers.get(firstIndex));
        System.out.println("Last element after swap: " + numbers.get(lastIndex));
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */

         for (Integer numbersInteger : numbers) {
            System.out.println(numbersInteger);
         }

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
         Map<String, Long> continentPopulation = new HashMap<>();

         continentPopulation.put("Africa", 1110635000L);
         continentPopulation.put("Americas", 972005000L);
         continentPopulation.put("Antartica", 0L);
         continentPopulation.put("Asia", 4298723000L);
         continentPopulation.put("Europe", 742452000L);
         continentPopulation.put("Oceania", 38304000L);
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
        // Step 2: Compute the population of the world by summing all the continent populations
        long worldPopulation = continentPopulation.values().stream().mapToLong(Long::longValue).sum();

        // Output the population of each continent
        System.out.println("Continent populations:");
        for (Map.Entry<String, Long> entry : continentPopulation.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Step 3: Output the world population
        System.out.println("\nTotal population of the world: " + worldPopulation);
        /*
         * 8) Compute the population of the world
         */
    }
}
