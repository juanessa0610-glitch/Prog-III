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
    }
}