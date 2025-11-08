import java.util.*;

public class subarray_with_sum_0 {

    public static int larLenSubArrWithSum0(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int len = 0;
        for(int j=0; j<arr.length; j++) {
            sum += arr[j];

            if(map.containsKey(sum)) {
                len = Math.max(len, j-map.get(sum));
            } else {
                map.put(sum, j);
            }
        }

        return len;
    }

    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};

        System.out.println(larLenSubArrWithSum0(arr));
    }
}
