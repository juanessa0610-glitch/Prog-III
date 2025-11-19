import java.util.*;

public class Graph {

    private int vertices;
    private List<List<Node>> adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    public void addEdge(int origen, int destino, int peso) {
        adjList.get(origen).add(new Node(destino, peso));
    }

    public List<List<Node>> getAdjList() {
        return adjList;
    }

    public int getVertices() {
        return vertices;
    }

    static class Node {
        int destino;
        int peso;

        Node(int d, int p) {
            destino = d;
            peso = p;
        }
    }
}
