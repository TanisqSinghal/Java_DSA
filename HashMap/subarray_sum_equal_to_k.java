import java.util.*;

public class subarray_sum_equal_to_k {

    public static int subArrSumEqualToK(int arr[], int k) { //O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        //(sum, count)

        map.put(0, 1); // essential because if sum - k = 0 , then 0 should be present already in map
        int sum = 0;
        int ans = 0;
        for(int j=0; j<arr.length; j++) {
            sum += arr[j]; //sum(j)

            if(map.containsKey(sum-k)) {
                ans += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {10, 2, -2, -20, 10};
        int k = -10;
        System.out.println(subArrSumEqualToK(arr, k));
    }
}
