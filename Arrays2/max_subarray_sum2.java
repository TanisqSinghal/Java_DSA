public class max_subarray_sum2 {

    public static int maxSubArrayssum(int arr[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            currSum = 0;
            for (int j = i; j < arr.length; j++) {
                currSum = currSum + arr[j];
                if(maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        return maxSum;
    }

    public static void main(String args[]) {
        int arr[] = {1,2,3,4,5};
        System.out.println(maxSubArrayssum(arr));
    }
}
