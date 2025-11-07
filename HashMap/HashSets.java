import java.util.*;

public class HashSets {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();

        hs.add("Delhi");
        hs.add("Mumbai");
        hs.add("Bengluru");
        hs.add("Telangana");

        // System.out.println(hs);
        // hs.clear();
        // System.out.println(hs.size());

        // Iterator it = hs.iterator();

        // while(it.hasNext()) {
        //     System.out.println(it.next());
        // }

        // for(String key: hs) { // more relatable
        //     System.out.println(key);
        // }

        //Linked Hashset

        // LinkedHashSet<String> set = new LinkedHashSet<>();

        // set.add("Delhi");
        // set.add("Mumbai");
        // set.add("Bengluru");
        // set.add("Noida");

        // for(String city : set) {
        //     System.out.println(city);
        // }

        //Tree set

        TreeSet<String> set = new TreeSet<>();

        set.add("Delhi");
        set.add("Mumbai");
        set.add("Bengluru");
        set.add("Nodia");

        System.out.println(set);

    }
}
