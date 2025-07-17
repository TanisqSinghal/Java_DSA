import java.util.*;

public class pair_sum {

    public static boolean pairSum(ArrayList<Integer> list, int target) {
        int st = 0, end = list.size()-1;
        while(st < end) {
            if(list.get(st) + list.get(end) == target) {
                return true;
            }
            else if(list.get(st) + list.get(end) < target) st++;
            else end--;
        }
        return false;
    }

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(pairSum(list, 5));
    }
}
