import java.util.ArrayList;

public class PruebaArray {

    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Shirose");
        nombres.add("Aila");
        nombres.add("Yosef");

        System.out.println(nombres);
        System.out.println("Tamaño del ArrayList: " + nombres.size());

        int indice = nombres.indexOf("Aila");
        System.out.println("El índice de 'Aila' es: " + indice);

        int noExiste = nombres.indexOf("Cass");
        System.out.println("El índice de 'Cass' es: " + noExiste);

        System.out.println("\nNombres que empiezan con 'A':");
        for (String nombre : nombres) {
            if (nombre.startsWith("A")) {
                System.out.println(nombre);
            }
        }

        String prefijo = "S";
        System.out.println("\nNombres que empiezan con '" + prefijo + "':");
        for (String nombre : nombres) {
            if (nombre.startsWith(prefijo)) {
                System.out.println(nombre);
            }
        }
    }
}