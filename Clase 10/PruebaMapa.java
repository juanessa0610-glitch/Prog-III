import java.util.HashMap;
import java.util.Map;

public class PruebaMapa{

    public static void main(String[] args) {
        Map<Integer,String> nombres = new HashMap<>();
        nombres.put(1, "Shirose");
        nombres.put(2, "Aila");
        nombres.put(3, "Yosef");
        System.out.println(nombres);
        System.out.println(nombres.size());


    }
}