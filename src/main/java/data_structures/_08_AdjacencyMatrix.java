package data_structures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class _08_Vertex {
    char data;

    _08_Vertex(char data) {
        this.data = data;
    }
}

class _08_Graph {
    ArrayList<_08_Vertex> vertices;
    int[][] matrix;

    _08_Graph(int size) {
        vertices = new ArrayList<>();
        matrix = new int[size][size];
    }

    public void addVertex(_08_Vertex vertex) {
        vertices.add(vertex);
    }

    public void addEdge(int src, int dst) {
        matrix[src][dst] = 1;
    }

    public boolean hasEdge(int src, int dst) {
        return matrix[src][dst] == 1;
    }

    public void printMatrix() {
        System.out.print("  ");
        for (_08_Vertex vertex : vertices) {
            System.out.print(vertex.data + " ");
        }
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(vertices.get(i).data + " ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void dfs(int src) {
        boolean[] visited = new boolean[matrix.length];
        dfsHelper(src, visited);
    }

    private void dfsHelper(int src, boolean[] visited) {
        if (visited[src]) {
            return;
        } else {
            visited[src] = true;
            System.out.print(vertices.get(src).data + " ");
        }

        for (int i = 0; i < matrix[src].length; i++) {
            if (hasEdge(src, i)) {
                dfsHelper(i, visited);
            }
        }
    }

    public void bfs(int src) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[matrix.length];

        queue.offer(src);
        visited[src] = true;

        while (!queue.isEmpty()) {
            src = queue.poll();
            System.out.print(vertices.get(src).data + " ");

            for (int i = 0; i < matrix[src].length; i++) {
                if (hasEdge(src, i) && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}

public class _08_AdjacencyMatrix {
    public static void main(String[] args) {
        _08_Graph graph = new _08_Graph(5);

        graph.addVertex(new _08_Vertex('A'));
        graph.addVertex(new _08_Vertex('B'));
        graph.addVertex(new _08_Vertex('C'));
        graph.addVertex(new _08_Vertex('D'));
        graph.addVertex(new _08_Vertex('E'));

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 0);
        graph.addEdge(4, 2);

        graph.printMatrix();
        System.out.println("There's an edge between 'D' and 'C'? " + graph.hasEdge(3, 2));

        System.out.println("DFS:");
        graph.dfs(4);
        System.out.println();

        System.out.println("BFS:");
        graph.bfs(4);
    }
}