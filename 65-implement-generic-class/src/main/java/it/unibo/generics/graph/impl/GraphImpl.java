package it.unibo.generics.graph.impl;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {

    private Map<N, Set<N>> graph;

    public GraphImpl() {
        graph = new LinkedHashMap<>();
    }

    @Override
    public void addNode(N node) {
        if (node != null) { //protezione
            if (!graph.containsKey(node)) {
                graph.put(node, new HashSet<>());
            }
        }
    }

    @Override
    public void addEdge(N source, N target) {
        if (source != null && target != null
            && graph.containsKey(target) && graph.containsKey(target)) { //protection
            graph.get(source).add(target);
        }
    }

    @Override
    public Set<N> nodeSet() {
        Set<N> temp = new HashSet<>();
        temp.addAll(graph.keySet());
        return temp;
    }

    @Override
    public Set<N> linkedNodes(N node) {
        Set<N> temp = new HashSet<>();
        for (N nd : graph.get(node)) {
            temp.add(nd);
        }
        return temp;
    }

    @Override
    public List<N> getPath(N source, N target) {
        BFS<N> bfs = new BFS<>(source, target);
        return bfs.breadthFirstSearch(this);
    }
}
