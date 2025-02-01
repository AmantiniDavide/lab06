package it.unibo.generics.graph.api;

import java.util.*;

public class SimpleGraph<N> implements Graph<N> {


    private final Map<N, Set<N>> adjacencyList = new HashMap<>();

   @Override
   public void addNode(N node){
    if(node != null && adjacencyList.containsKey(node)){
        adjacencyList.put(node, new HashSet<>());
    }

   }

   @Override
   public void addEdge(N source, N target){
    if (source == null || target == null) {
        return;
    }
    
    // Inizializza il set per source se non è già presente
    adjacencyList.putIfAbsent(source, new HashSet<>());
    
    // Aggiungi il target al set dei collegamenti di source
    adjacencyList.get(source).add(target);
   }

   @Override
   public Set<N> nodeSet(){
    return Collections.unmodifiableSet(adjacencyList.keySet());
   }

   @Override
   public Set<N> linkedNodes(N node){
    return node != null && adjacencyList.containsKey(node) ? Collections.unmodifiableSet(adjacencyList.get(node)) : Collections.emptySet();
   }

   @Override
   public List<N> getPath(N source, N target) {
       if (source == null || target == null || !adjacencyList.containsKey(source) || !adjacencyList.containsKey(target)) {
           return Collections.emptyList();
       }
       // Effettuiamo una ricerca in ampiezza (BFS) per trovare un percorso
       Queue<List<N>> queue = new LinkedList<>();
       Set<N> visited = new HashSet<>();
       queue.add(Collections.singletonList(source));
       visited.add(source);
   
       while (!queue.isEmpty()) {
           List<N> path = queue.poll();
           N lastNode = path.get(path.size() - 1);
   
           if (lastNode.equals(target)) {
               return path;
           }
   
           for (N neighbor : linkedNodes(lastNode)) {
               if (!visited.contains(neighbor)) {
                   visited.add(neighbor);
                   List<N> newPath = new ArrayList<>(path);
                   newPath.add(neighbor);
                   queue.add(newPath);
               }
           }
       }
       return Collections.emptyList();  // Nessun percorso trovato
   }
}