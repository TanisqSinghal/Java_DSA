public class matrix_chain_multiplication {

    public static int matrixChainMultiplication(int arr[], int i, int j) {
        if(i == j) return 0;
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++) {
            int cost1 = matrixChainMultiplication(arr, i, k);
            int cost2 = matrixChainMultiplication(arr, k+1, j);
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};
        System.out.println(matrixChainMultiplication(arr, 1, arr.length-1));
    }
}
