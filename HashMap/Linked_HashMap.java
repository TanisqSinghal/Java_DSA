import java.util.*;

public class Linked_HashMap {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        lhm.put("India", 100);
        lhm.put("US", 50);
        lhm.put("China", 150);

        System.out.println(lhm);

    }
}
