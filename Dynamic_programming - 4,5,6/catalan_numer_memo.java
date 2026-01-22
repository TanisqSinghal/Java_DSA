public class catalan_numer_memo {
    public static int catalanRec(int n, int dp[]) {
        if(n == 0 || n == 1) {
            return 1;
        }
        if(dp[n] != -1) {
            return dp[n];
        }
        int ans = 0;
        for(int i=0; i<=n-1; i++) {
            ans += catalanRec(i, dp) * catalanRec(n-i-1, dp);
        }

        return dp[n] = ans;
    }

    public static void main(String[] args) {
        int n = 15;
        int dp[] = new int[n+1];
        for(int i=0; i<n+1; i++){
            dp[i] = -1;
        }
        System.out.println(catalanRec(n, dp));
    }

}
