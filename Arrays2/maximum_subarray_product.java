public class maximum_subarray_product {
    public static int kadans(int arr[]) {
        int ms = arr[0]; // maximum sum
        int cs = arr[0],count=0; // current sum
        for (int i = 1; i < arr.length; i++) {
            cs = cs * arr[i];
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
        int arr[] = {-2, 3, -4};
        System.out.println(kadans(arr));
    }
}
