import java.util.*;

public class MatrizAListaSimple {
    public static void main(String[] args) {
        int[][] matriz = {
            {0, 1, 1, 0},
            {1, 0, 0, 1},
            {1, 0, 0, 1},
            {0, 1, 1, 0}
        };

        // Crear lista de adyacencia
        List<LinkedList<Integer>> lista = new ArrayList<>();

        for (int i = 0; i < matriz.length; i++) {
            LinkedList<Integer> nodos = new LinkedList<>();
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 1)
                    nodos.add(j);
            }
            lista.add(nodos);
        }

        // Mostrar la lista
        for (int i = 0; i < lista.size(); i++) {
            System.out.print((char)('A' + i) + " -> ");
            for (int nodo : lista.get(i))
                System.out.print((char)('A' + nodo) + " ");
            System.out.println();
        }
    }
}