import java.util.HashMap;

public class PrimjerMap {
    public static void main(String[] args) {
//        TreeMap<String, Integer> map = new TreeMap<>();
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Dinko", 32);
        map.put("Ana", 31);
        map.put("Daniel", 43);

        System.out.println("Daniel: " + map.get("Daniel"));
    }
}

