
public class knapsack_01_memo {
    //TC - O(n * W)
    public static int knapsack(int val[], int wt[], int[][] dp, int W, int n) {
        if(W == 0 || n == 0) {
            return 0;
        }

        if(dp[n][W] != 0) {
            return dp[n][W];
        }

        if(wt[n-1] <= W) { // valid case
            //include
            int ans1 = val[n-1] + knapsack(val, wt, dp, W-wt[n-1], n-1);
            //exclude
            int ans2 = knapsack(val, wt, dp, W, n-1);

            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        }
        else { //invalid case
            dp[n][W] = knapsack(val, wt, dp, W, n-1);
            return dp[n][W];
        }
    }

    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        int n = val.length;
        int dp[][] = new int[val.length+1][W+1];

        System.out.println(knapsack(val, wt, dp, W, n));
    }
}
