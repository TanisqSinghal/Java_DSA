import java.util.*;
public class Arraylist {
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=5; i++) {
            list.add(i);
        }

        // for(int i=list.size()-1; i>=0; i--) {
        //     System.out.print(list.get(i)+" ");
        // }

        //maximum
        int max = Integer.MIN_VALUE;
        for(int i=0; i<list.size(); i++) {
            if(max < list.get(i)) {
                max = list.get(i);
            }
        }
        System.out.println(max);
    }
}
