package data_structures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class _07_Vertex {
    char data;

    _07_Vertex(char data) {
        this.data = data;
    }
}

class _07_Graph {
    HashMap<Character, LinkedList<_07_Vertex>> graphMap;

    _07_Graph() {
        graphMap = new HashMap<>();
    }

    public void addVertex(_07_Vertex vertex) {
        LinkedList<_07_Vertex> newList = new LinkedList<>();
        newList.add(vertex);
        graphMap.put(vertex.data, newList);
    }

    public void addEdge(char src, char dst) {
        LinkedList<_07_Vertex> currentList = graphMap.get(src);
        _07_Vertex dstVertex = graphMap.get(dst).getFirst();
        currentList.add(dstVertex);
    }

    public boolean hasEdge(char src, char dst) {
        LinkedList<_07_Vertex> currentList = graphMap.get(src);
        _07_Vertex dstVertex = graphMap.get(dst).getFirst();
        return currentList.contains(dstVertex);
    }

    public void printList() {
        for (char key : graphMap.keySet()) {
            for (_07_Vertex vertex : graphMap.get(key)) {
                System.out.print(vertex.equals(graphMap.get(key).getLast())?
                        vertex.data : vertex.data + " -> "
                );
            }
            System.out.println();
        }
    }

    public void dfs(char src) {
        HashMap<Character, Boolean> visited = new HashMap<>();

        for (char key : graphMap.keySet()) {
            visited.put(key, false);
        }

        dfsHelper(src, visited);
    }

    private void dfsHelper(char src, HashMap<Character, Boolean> visited) {
        visited.replace(src, true);
        System.out.print(src + " - ");

        for (_07_Vertex vertex : graphMap.get(src)) {
            if (!visited.get(vertex.data)) {
                dfsHelper(vertex.data, visited);
            }
        }
    }

    public void bfs(char src) {
        Queue<Character> queue = new LinkedList<>();
        HashMap<Character, Boolean> visited = new HashMap<>();

        for (char key : graphMap.keySet()) {
            visited.put(key, false);
        }

        queue.offer(src);
        visited.put(src, true);

        while (!queue.isEmpty()) {
            src = queue.poll();
            System.out.print(src + " - ");

            for (_07_Vertex vertex : graphMap.get(src)) {
                if (!visited.get(vertex.data)) {
                    queue.offer(vertex.data);
                    visited.put(vertex.data, true);
                }
            }
        }
    }
}

public class _07_AdjacencyList {
    public static void main(String[] args) {
        _07_Graph graph = new _07_Graph();

        graph.addVertex(new _07_Vertex('A'));
        graph.addVertex(new _07_Vertex('B'));
        graph.addVertex(new _07_Vertex('C'));
        graph.addVertex(new _07_Vertex('D'));
        graph.addVertex(new _07_Vertex('E'));

        graph.addEdge('A', 'B');
        graph.addEdge('B', 'C');
        graph.addEdge('C', 'D');
        graph.addEdge('C', 'E');
        graph.addEdge('E', 'A');
        graph.addEdge('E', 'C');

        graph.printList();
        System.out.println("Vertices 'B' and 'C' have an edge: " + graph.hasEdge('B', 'C'));

        System.out.println("DFS:");
        graph.dfs('A');

        System.out.println();

        System.out.println("BFS:");
        graph.bfs('C');
    }
}