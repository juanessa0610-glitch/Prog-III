import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ColaMapaP2 {

    // Clase interna de cola circular de enteros
    static class ColaCircularEnteros {
        private int[] datos;
        private int cabeza;
        private int cola;
        private int tam;

        // Constructor: inicializa la cola vacía con la capacidad dada
        public ColaCircularEnteros(int capacidad) {
            datos = new int[capacidad];
            cabeza = 0;
            cola = 0;
            tam = 0;
        }
        // Retorna true si no hay elementos
        public boolean estaVacia() { return tam == 0; }

        // Retorna true si la cola está llena
        public boolean estaLlena() { return tam == datos.length; }

        // Agrega un elemento al final de la cola
        public void encolar(int x) {
            if (estaLlena()) throw new IllegalStateException("Cola llena");
            datos[cola] = x;
            cola = (cola + 1) % datos.length;
            tam++;
        }

        // Quita y retorna el elemento del frente
        public int desencolar() {
            if (estaVacia()) throw new IllegalStateException("Cola vacía");
            int v = datos[cabeza];
            cabeza = (cabeza + 1) % datos.length;
            tam--;
            return v;
        }
    }

    // (50 pts) Calcula el balance de paréntesis encolando +1 y -1
    public static int balanceConCola(String s) {
        ColaCircularEnteros cola = new ColaCircularEnteros(s.length());

         // Encolar +1 por '(' y -1 por ')'
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                cola.encolar(1);
            } else if (c == ')') {
                cola.encolar(-1);
            }
        }

        int suma = 0;

        // Desencolar todos los valores y sumarlos
        while (!cola.estaVacia()) {
            suma += cola.desencolar();
        }

        return suma; // balance final (0 si hay misma cantidad)
    }

    // (50 pts) Registra intentos por nombre en un mapa
    public static int registrarIntento(Map<String, Integer> intentos, String nombre) {
        int valorActual;

        // Si el nombre existe, incrementar en 1
        if (intentos.containsKey(nombre)) {
            valorActual = intentos.get(nombre);
            valorActual++;
            intentos.put(nombre, valorActual);
        } else {

            // Si no existe, iniciar en 1
            intentos.put(nombre, 1);
            valorActual = 1;
        }

        return valorActual; // devuelve el nuevo número de intentos
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese una cadena con paréntesis:");
        String cadena = sc.nextLine();
        System.out.println("Balance cola: " + balanceConCola(cadena));

        Map<String, Integer> intentos = new HashMap<String, Integer>();
        System.out.println("Intentos (Ana): " + registrarIntento(intentos, "Ana"));
        System.out.println("Intentos (Ana): " + registrarIntento(intentos, "Ana"));

        sc.close();
    }
}