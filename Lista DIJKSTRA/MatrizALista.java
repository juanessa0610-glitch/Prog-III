import java.util.*;

public class MatrizALista {
    public static void main(String[] args) {
        int[][] matriz = {
            {0, 1, 1, 0},
            {1, 0, 0, 1},
            {1, 0, 0, 1},
            {0, 1, 1, 0}
        };

        // La lista contendrá una lista enlazada por cada fila
        List<LinkedList<Integer>> listaAdyacencia = new ArrayList<>(matriz.length);

        // Transformar matriz → lista enlazada
        for (int i = 0; i < matriz.length; i++) {
            LinkedList<Integer> nodos = new LinkedList<>();
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 1) // hay conexión
                    nodos.add(j);
            }
            listaAdyacencia.add(nodos); // agregamos la lista enlazada del nodo i
        }

        // Mostrar el resultado
        for (int i = 0; i < listaAdyacencia.size(); i++) {
            System.out.print((char)('A' + i) + " -> ");
            for (int nodo : listaAdyacencia.get(i))
                System.out.print((char)('A' + nodo) + " ");
            System.out.println();
        }
    }
}