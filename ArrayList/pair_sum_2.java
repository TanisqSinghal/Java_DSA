import java.util.ArrayList;

public class pair_sum_2 {

    public static boolean pairSum_Rotated(ArrayList<Integer> list, int target) {
        int bp = -1;
        for(int i=0; i<list.size()-1; i++) {
            if(list.get(i) > list.get(i+1)) {
                bp = i; 
                break;
            }
        }
        int st = bp+1, end = bp;
        while(st != end) {
            if(list.get(st) + list.get(end) == target) {
                return true;
            }
            else if(list.get(st) + list.get(end) < target) st = (st+1) % list.size();
            else end = (list.size()+end-1) % list.size();
        }
        return false;
    }

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        System.out.println(pairSum_Rotated(list, 16));
    }
}
