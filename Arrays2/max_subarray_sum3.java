
public class max_subarray_sum3 {
    // kadan's alogrithm
    public static int kadans(int arr[]) {
        int ms = Integer.MIN_VALUE; // maximum sum
        int cs = 0,count=0; // current sum
        for (int i = 0; i < arr.length; i++) {
            cs = cs + arr[i];
            if (cs < 0) {
                cs = 0;
            }
            if (ms < cs) {
                ms = cs;
            }
            if(arr[i] < 0) {
                count++;
            }
        }
        if(count == arr.length ) {
            int max = Integer.MIN_VALUE;
            for(int i=0; i<arr.length; i++) {
                max = Math.max(max, arr[i]);
            }
            return max;
        }
        return ms;
    }

    public static void main(String args[]) {
        int arr[] = { -2, -3, 5, -9, -8 };
        System.out.println(kadans(arr));
    }
}
