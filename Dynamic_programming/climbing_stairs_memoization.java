public class climbing_stairs_memoization {

    public static int climbingStairsMemo(int n, int[] dp) {
        if(n == 0) {
            return 1;
        }
        else if(n < 0) {
            return 0;
        }

        if(dp[n] != 0) {
            return dp[n];
        }

        dp[n] = climbingStairsMemo(n-1, dp) + climbingStairsMemo(n-2, dp);
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        int dp[] = new int[n+1];

        System.out.println(climbingStairsMemo(n, dp));
    }
}
