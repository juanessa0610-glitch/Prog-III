import java.util.*;

// ---------------------------------
// ALGORITMO DE DIJKSTRA
// ---------------------------------
class Dijkstra {
    public static Map<String, Integer> calcularDistancias(Map<String, List<Nodo>> grafo, String inicio) {
        Map<String, Integer> distancias = new HashMap<>();
        for (String nodo : grafo.keySet()) {
            distancias.put(nodo, Integer.MAX_VALUE);
        }
        distancias.put(inicio, 0);

        PriorityQueue<Nodo> cola = new PriorityQueue<>(Comparator.comparingInt(n -> n.peso));
        cola.add(new Nodo(inicio, 0));

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            if (actual.peso > distancias.get(actual.nombre)) continue;

            for (Nodo vecino : grafo.get(actual.nombre)) {
                int nuevaDistancia = distancias.get(actual.nombre) + vecino.peso;
                if (nuevaDistancia < distancias.get(vecino.nombre)) {
                    distancias.put(vecino.nombre, nuevaDistancia);
                    cola.add(new Nodo(vecino.nombre, nuevaDistancia));
                }
            }
        }
        return distancias;
    }
}

class Nodo {
    String nombre;
    int peso;

    public Nodo(String nombre, int peso) {
        this.nombre = nombre;
        this.peso = peso;
    }
}

// ---------------------------------
// MÉTODOS DE ORDENAMIENTO
// ---------------------------------
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

// ---------------------------------
// EJECUTADOR PRINCIPAL
// ---------------------------------
public class Main {
    public static void main(String[] args) {
        // ----- Dijkstra -----
        Map<String, List<Nodo>> grafo = new HashMap<>();
        grafo.put("A", Arrays.asList(new Nodo("B", 1), new Nodo("C", 4)));
        grafo.put("B", Arrays.asList(new Nodo("A", 1), new Nodo("C", 2), new Nodo("D", 5)));
        grafo.put("C", Arrays.asList(new Nodo("A", 4), new Nodo("B", 2), new Nodo("D", 1)));
        grafo.put("D", Arrays.asList(new Nodo("B", 5), new Nodo("C", 1)));

        System.out.println("Distancias mínimas desde A:");
        Map<String, Integer> distancias = Dijkstra.calcularDistancias(grafo, "A");
        for (String nodo : distancias.keySet()) {
            System.out.println("A → " + nodo + " = " + distancias.get(nodo));
        }

        // ----- Ordenamientos -----
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
    }
}