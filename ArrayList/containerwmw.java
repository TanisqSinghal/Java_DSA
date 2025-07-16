import java.util.*;

public class containerwmw {

    public static int containerWithMostWater(ArrayList<Integer> list) {
        int st = 0, end = list.size()-1;
        int maxWater = Integer.MIN_VALUE;
        while(st < end) {
            int width = end-st;
            int ht = Math.min(list.get(st), list.get(end));
            int currWater = ht * width;
            maxWater = Math.max(maxWater, currWater);
            if(list.get(st) < list.get(end)) {
                st++;
            }
            else {
                end--;
            }
        }
        return maxWater;
    }

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);
        System.out.println(containerWithMostWater(list));
    }
}
