import java.util.*;

public class weakest_soldier {

    private static class pair implements Comparable<pair> {
        int sum;
        int idx;

        public pair(int sum, int idx) {
            this.sum = sum;
            this.idx = idx;
        }
        @Override
        public int compareTo(pair p2) {
            if(this.sum == p2.sum) {
                return this.idx - p2.idx;
            } else {
                return this.sum - p2.sum;
            }
        }
    }

    public static void main(String[] args) {
        int weakest[][] = {{1,0,0,0},
                           {1,1,1,1},
                           {1,0,0,0},
                           {1,0,0,0}};
        int k = 2;
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for(int i=0; i<weakest.length; i++) {
            int sum = 0;
            for(int j=0; j<weakest[0].length; j++) {
                sum += weakest[i][j];
            }
            pq.add(new pair(sum, i));
        }
        for(int i=0; i<k; i++) {
            System.out.println("R"+pq.remove().idx);
        }
    }
}
