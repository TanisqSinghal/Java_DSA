
public class max_subarraysum1 {

    public static int maxSubArrayssum(int arr[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                currSum = 0;
                for(int k=i; k<=j; k++) {
                   currSum = currSum + arr[k];
                }
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
