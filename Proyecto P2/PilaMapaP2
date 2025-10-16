import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PilaMapaP2 {

     // Clase interna que implementa una pila de enteros
    static class PilaEnteros {
        private int[] datos;
        private int tope; // -1 si está vacía

        // Constructor: crea la pila con la capacidad indicada
        public PilaEnteros(int capacidad) {
            datos = new int[capacidad];
            tope = -1;
        }

        // Retorna true si no hay elementos en la pila
        public boolean estaVacia() { return tope == -1; }
         // Retorna true si la pila está llena
        public boolean estaLlena() { return tope + 1 == datos.length; }

        // Agrega un elemento en la parte superior de la pila
        public void apilar(int x) {
            if (estaLlena()) throw new IllegalStateException("Pila llena");
            tope++;
            datos[tope] = x;
        }

         // Quita y devuelve el elemento superior de la pila
        public int desapilar() {
            if (estaVacia()) throw new IllegalStateException("Pila vacía");
            int v = datos[tope];
            tope--;
            return v;
        }
    }

    // (50 pts) Verifica si los paréntesis están balanceados
    public static boolean esBalanceado(String s) {
        PilaEnteros pila = new PilaEnteros(s.length()); // pila del tamaño de la cadena

        // Recorre cada carácter de la cadena
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
             // Si es '(', apilar un valor
            if (c == '(') {
                pila.apilar(1); 

               // Si es ')', desapilar un valor
            } else if (c == ')') {

                // Si no hay '(' para emparejar, está desbalanceado
                if (pila.estaVacia()) {
                    return false; 
                }
                pila.desapilar(); // quita un '(' emparejado
            }
        }
         // Si al final la pila está vacía, los paréntesis están balanceados
        return pila.estaVacia();
    }

    // (50 pts) Actualiza la calificación si el id existe y está en rango 0..100
    public static boolean actualizarCalificacion(Map<Integer, Integer> califPorId, int id, int nuevo) 
    {
        // Validar que la calificación esté dentro del rango 0..100
        if (nuevo < 0 || nuevo > 100) {
            return false; 
        }

         // Verificar que el id exista en el mapa
        if (!califPorId.containsKey(id)) {
            return false; 
        }

         // Actualizar la calificación
        califPorId.put(id, nuevo);
        return true;
    }

    // Programa principal de prueba
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese una cadena con paréntesis:");
        String cadena = sc.nextLine();
        System.out.println("Balanceado: " + esBalanceado(cadena));

        Map<Integer, Integer> mapa = new HashMap<Integer, Integer>();
        mapa.put(101, 70);
        System.out.println("Actualizado: " + actualizarCalificacion(mapa, 101, 95));

        sc.close();
    }
}