import java.util.ArrayDeque;
import java.util.Deque;

public class EjecutarTaller {
    public static void main(String[] args) {
        Taller taller = new Taller();

        // Probar ContarVotos
        System.out.println("Resultado de votos: " + taller.ContarVotos(3, 5)); 

        // Probar mismoPan
        Deque<String> s1 = new ArrayDeque<>();
        s1.offer("pan blanco");
        s1.offer("lechuga");
        s1.offer("pan blanco");

        Deque<String> s2 = new ArrayDeque<>();
        s2.offer("pan blanco");
        s2.offer("tomate");
        s2.offer("pan blanco");

        boolean r1 = taller.mismoPan(s1, s2);
        System.out.println("Resultado (ejemplo 1): " + r1); // true

        Deque<String> s3 = new ArrayDeque<>();
        s3.offer("pan integral");
        s3.offer("queso");
        s3.offer("pan integral");

        Deque<String> s4 = new ArrayDeque<>();
        s4.offer("pan blanco");
        s4.offer("queso");
        s4.offer("pan integral");

        boolean r2 = taller.mismoPan(s3, s4);
        System.out.println("Resultado (ejemplo 2): " + r2); // false
    }
}
