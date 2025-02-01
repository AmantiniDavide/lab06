package it.unibo.generics.graph;

import it.unibo.generics.graph.api.Graph;
import it.unibo.generics.graph.api.SimpleGraph;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

/**
 *
 */
public final class UseGraph {

    private UseGraph() {
    }

    public static void main(final String... args) {
        /*
         * Creiamo un'istanza di SimpleGraph e testiamo la sua implementazione
         */
        Graph<String> graph = new SimpleGraph<>();
        testGraph(graph);
    }

    private static void testGraph(final Graph<String> graph) {
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        graph.addEdge("a", "b");
        graph.addEdge("b", "c");
        graph.addEdge("c", "d");
        graph.addEdge("d", "e");
        graph.addEdge("c", "a");
        graph.addEdge("e", "a");
        
        /*
         * Dovrebbe essere ["a","b","c","d","e"], in qualsiasi ordine
         */
        assertIsAnyOf(graph.nodeSet(), Set.of(splitOnWhiteSpace("a b c d e")));
        
        /*
         * Dovrebbe essere ["d","a"], in qualsiasi ordine
         */
        assertIsAnyOf(graph.linkedNodes("c"), Set.of(splitOnWhiteSpace("a d")));
        
        /*
         * Dovrebbe essere uno dei seguenti percorsi: b,c,a o b,c,d,e,a
         */
        assertIsAnyOf(
            graph.getPath("b", "a"),
            Arrays.asList(splitOnWhiteSpace("b c a")),
            Arrays.asList(splitOnWhiteSpace("b c d e a"))
        );
    }

    private static void assertIsAnyOf(final Object actual, final Object... valid) {
        for (final var target: Objects.requireNonNull(valid)) {
            if (Objects.equals(target, actual)) {
                System.out.println("OK: " + actual + " matches " + target);
                return;
            }
        }
        throw new AssertionError("None of " + Arrays.asList(valid) + " matches " + actual);
    }

    private static String[] splitOnWhiteSpace(final String target) {
        return target.split("\\s+");
    }
}