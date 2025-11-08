import java.util.HashSet;

public class UnionAndInternsection {

    public static void main(String[] args) {
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};

        HashSet<Integer> set = new HashSet<>();

        //Union
        for(int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }

        for(int i=0; i<arr2.length; i++) {
            set.add(arr2[i]);
        }

        System.out.println("Union : "+set.size());
        System.out.println(set);

        //Intersection
        set.clear();;

        for(int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }
            
        int count = 0;
        System.out.print("[");
        for(int key : arr2) {
            if(set.contains(key)) {
                count++;
                System.out.print(key+", ");
                set.remove(key);
            }
        }
        System.out.println("]");

        System.out.println("Intersection : "+count);
    }
}
