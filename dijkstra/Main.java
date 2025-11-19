import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Indices de ciudades
        /*
            0 = Cali
            1 = Medellín
            2 = Bogotá
            3 = Bucaramanga
            4 = Cartagena
        */

        Graph g = new Graph(5);

        // Grafo basado en mapa de Colombia
        g.addEdge(0, 1, 420); // Cali → Medellín
        g.addEdge(0, 2, 460); // Cali → Bogotá
        g.addEdge(1, 4, 640); // Medellín → Cartagena
        g.addEdge(2, 3, 400); // Bogotá → Bucaramanga
        g.addEdge(3, 4, 260); // Bucaramanga → Cartagena
        g.addEdge(1, 2, 415); // Medellín → Bogotá

        int[] distancias = Dijkstra.calcular(g, 0);

        System.out.println("Distancia mínima de cada ciudad desde Cali:");
        System.out.println("Cali: " + distancias[0]);
        System.out.println("Medellín: " + distancias[1]);
        System.out.println("Bogotá: " + distancias[2]);
        System.out.println("Bucaramanga: " + distancias[3]);
        System.out.println("Cartagena: " + distancias[4]);

        // Ordenamiento para obtener el menor recorrido
        int[] copia = distancias.clone();
        Arrays.sort(copia);

        System.out.println("\nRecorridos ordenados (menor a mayor): ");
        for (int d : copia) {
            System.out.println(d);
        }
    }
}
