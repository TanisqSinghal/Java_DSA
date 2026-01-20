public class climbing_stairs_tabulation {

    public static int climbingStairsTabu(int n) {
        if(n < 0) {
            return 0;
        }

        int dp[] = new int[n+1];
        dp[0] = 1;

        for(int i=1; i<=n; i++) {
            dp[i] = dp[i-1] + ( (i-2) < 0 ? 0 : dp[i-2]);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbingStairsTabu(n));
    }
}
