import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Deque;

public class Taller {

    // Método para contar votos
    public int ContarVotos(int DownVotes, int UpVotes) {
        Queue<Integer> votosPositivos = new ArrayDeque<>();
        Queue<Integer> votosNegativos = new ArrayDeque<>();
        for (int i = 0; i < UpVotes; i++) {
            votosPositivos.add(1);
        }
        for (int i = 0; i < DownVotes; i++) {
            votosNegativos.add(-1);
        }
        return votosPositivos.size() - votosNegativos.size();
    }

    // Método para comparar si los panes son iguales al inicio y al final
    public boolean mismoPan(Deque<String> cola1, Deque<String> cola2) {
        if (cola1.isEmpty() || cola2.isEmpty()) return false;

        String primero1 = cola1.peekFirst();
        String ultimo1 = cola1.peekLast();
        String primero2 = cola2.peekFirst();
        String ultimo2 = cola2.peekLast();

        return primero1.equals(primero2) && ultimo1.equals(ultimo2);
    }
}
