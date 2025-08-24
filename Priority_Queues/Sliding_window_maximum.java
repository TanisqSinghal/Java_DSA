import java.util.Comparator;
import java.util.PriorityQueue;

public class Sliding_window_maximum {

    static class Info {
        int val;
        int idx;

        public Info(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int result[] = new int[arr.length - k + 1];

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt((Info i) -> i.val).reversed());

        for(int i=0; i<k; i++) {
            pq.add(new Info(arr[i], i));
        }

        result[0] = pq.peek().val;

        for(int i=k; i<arr.length; i++) {
            while(pq.size() > 0 && pq.peek().idx <= i-k) {
                pq.remove();
            }

            pq.add(new Info(arr[i], i));
            result[i-k+1] = pq.peek().val;
        }

        for(int i=0; i<result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }   
}
