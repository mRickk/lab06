package it.unibo.generics.graph.impl;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import it.unibo.generics.graph.api.Graph;

public class BFS<N> {

    private N source;
    private N target;
    private Map<N, N> explored; //<node, father>

    public BFS(N source, N target) {
        this.source = source;
        this.target = target;
        this.explored = new HashMap<>();
    }

    public List<N> breadthFirstSearch(Graph<N> graph) {
        Queue<N> queue = new ArrayDeque<>(graph.nodeSet().size());        
        N v;        
        explored.put(source, null);        
        queue.add(source);
        while(!queue.isEmpty()) {
            v = queue.remove();
            if (v == target) {
                return bfsPathReconstruction(explored);
            }
            for (N w : graph.linkedNodes(v)) {
                if (!explored.containsKey(w)) {
                    explored.put(w, v);
                    queue.add(w);
                }
            }
        }
        return new LinkedList<>(); //not reachable target
    }

    private List<N> bfsPathReconstruction(Map<N, N> explored) {
        List<N> path = new LinkedList<>();
        while(target != null) {
            path.add(0, target);
            target = explored.get(target); //gets father
        }
        return path;
    }
}
