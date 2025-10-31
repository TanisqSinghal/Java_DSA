import java.util.*;

public class HashMap_intro {
    public static void main(String[] args) {
        //create a hashmap
        HashMap<String,Integer> hm = new HashMap<>();

        //insert the element - O(1)
        hm.put("India", 100);
        hm.put("US", 50);
        hm.put("China", 150);

        System.out.println(hm);

        //get - O(1)
        System.out.println(hm.get("India"));
        System.out.println(hm.get("Indonesia"));

        //containsKey = O(1)
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Indonesia"));

        //removes() - O(1)
        System.out.println(hm.remove("India"));
        System.out.println(hm.remove("Nepal"));

        //Size function 
        System.out.println(hm.size());

        //isEmpty() 
        System.out.println(hm.isEmpty());

        //clear function
        hm.clear();
        System.out.println(hm.size());
        System.out.println(hm.isEmpty());
    }
}
