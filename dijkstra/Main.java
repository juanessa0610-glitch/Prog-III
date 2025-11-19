import java.util.*;

class DijkstraMatriz {
    public static int[] calcularDistancias(int[][] grafo, int inicio) {
        int n = grafo.length;
        int[] distancias = new int[n];
        boolean[] visitado = new boolean[n];

       
        Arrays.fill(distancias, Integer.MAX_VALUE);
        distancias[inicio] = 0;

        
        for (int i = 0; i < n - 1; i++) {
            int u = minimoDistancia(distancias, visitado);
            visitado[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visitado[v] && grafo[u][v] != 0 && distancias[u] != Integer.MAX_VALUE
                        && distancias[u] + grafo[u][v] < distancias[v]) {
                    distancias[v] = distancias[u] + grafo[u][v];
                }
            }
        }
        return distancias;
    }

    private static int minimoDistancia(int[] distancias, boolean[] visitado) {
        int min = Integer.MAX_VALUE, indiceMin = -1;
        for (int v = 0; v < distancias.length; v++) {
            if (!visitado[v] && distancias[v] <= min) {
                min = distancias[v];
                indiceMin = v;
            }
        }
        return indiceMin;
    }
}


class Ordenamientos {

    public static int[] burbuja(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void quickSort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int indicePivote = particion(arr, inicio, fin);
            quickSort(arr, inicio, indicePivote - 1);
            quickSort(arr, indicePivote + 1, fin);
        }
    }

    private static int particion(int[] arr, int inicio, int fin) {
        int pivote = arr[fin];
        int i = inicio - 1;
        for (int j = inicio; j < fin; j++) {
            if (arr[j] < pivote) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;
        return i + 1;
    }

    public static int[] insercion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int clave = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > clave) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = clave;
        }
        return arr;
    }

    public static int[] seleccion(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) return arr;
        int mitad = arr.length / 2;

        int[] izquierda = Arrays.copyOfRange(arr, 0, mitad);
        int[] derecha = Arrays.copyOfRange(arr, mitad, arr.length);

        return merge(mergeSort(izquierda), mergeSort(derecha));
    }

    private static int[] merge(int[] izq, int[] der) {
        int[] resultado = new int[izq.length + der.length];
        int i = 0, j = 0, k = 0;
        while (i < izq.length && j < der.length) {
            if (izq[i] < der[j]) {
                resultado[k++] = izq[i++];
            } else {
                resultado[k++] = der[j++];
            }
        }
        while (i < izq.length) resultado[k++] = izq[i++];
        while (j < der.length) resultado[k++] = der[j++];
        return resultado;
    }
}


public class Main {
    public static void main(String[] args) {
        try {
            
            int[][] grafo = {
                {0, 1, 4, 0},
                {1, 0, 2, 5},
                {4, 2, 0, 1},
                {0, 5, 1, 0}
            };

            String[] nombres = {"A", "B", "C", "D"};
            int inicio = 0;

            int[] distancias = DijkstraMatriz.calcularDistancias(grafo, inicio);
            System.out.println("Distancias mínimas desde " + nombres[inicio] + ":");
            for (int i = 0; i < distancias.length; i++) {
                System.out.println(nombres[inicio] + " → " + nombres[i] + " = " + distancias[i]);
            }

            
            int[] datos = {64, 25, 12, 22, 11};

            System.out.println("\nLista original: " + Arrays.toString(datos));

            int[] burbuja = datos.clone();
            System.out.println("Burbuja: " + Arrays.toString(Ordenamientos.burbuja(burbuja)));

            int[] quick = datos.clone();
            Ordenamientos.quickSort(quick, 0, quick.length - 1);
            System.out.println("Quick Sort: " + Arrays.toString(quick));

            int[] insercion = Ordenamientos.insercion(datos.clone());
            System.out.println("Inserción: " + Arrays.toString(insercion));

            int[] seleccion = Ordenamientos.seleccion(datos.clone());
            System.out.println("Selección: " + Arrays.toString(seleccion));

            int[] merge = Ordenamientos.mergeSort(datos.clone());
            System.out.println("Merge Sort: " + Arrays.toString(merge));

        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}