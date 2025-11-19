import java.util.*;

public class Dijkstra {

    public static int[] calcular(Graph graph, int start) {

        int V = graph.getVertices();
        int[] dist = new int[V];
        boolean[] visitado = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] actual = pq.poll();
            int nodo = actual[0];

            if (visitado[nodo]) continue;
            visitado[nodo] = true;

            for (Graph.Node vecino : graph.getAdjList().get(nodo)) {
                int nuevoDist = dist[nodo] + vecino.peso;

                if (nuevoDist < dist[vecino.destino]) {
                    dist[vecino.destino] = nuevoDist;
                    pq.add(new int[]{vecino.destino, nuevoDist});
                }
            }
        }
        return dist;
    }
}
