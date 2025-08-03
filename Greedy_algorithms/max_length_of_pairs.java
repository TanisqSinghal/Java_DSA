import java.util.*;

public class max_length_of_pairs {
    public static void main(String[] args) {
        int pairs[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int lastEnd = pairs[0][1];
        int length = 1;
        ArrayList<Integer> pairIdx = new ArrayList<>();
        pairIdx.add(0);
        for(int i=1; i<pairs.length; i++) {
            if(pairs[i][0] > lastEnd) {
                length++;
                lastEnd = pairs[i][1];
                pairIdx.add(i);
            }
        }
        System.out.println("max length of chain: "+length);
        for(int i=0; i<pairIdx.size(); i++) {
            System.err.print("P"+pairIdx.get(i)+" ");
        }
    }
}