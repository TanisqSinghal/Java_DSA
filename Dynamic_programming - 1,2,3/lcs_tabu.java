public class lcs_tabu {

    public static int lcsTabulation(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int dp[][] = new int[n+1][m+1];
        dp[0][0] = 0;

        for(int i=1; i<=m; i++) {
            dp[0][i] = 0;
        };

        for(int i=1; i<=n; i++) {
            dp[i][0] = 0;
        };

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[n][m];

    }

    public static void main(String[] args) {
        String str1 = "ABCD";
        String str2 = "ACEB";

        System.out.println(lcsTabulation(str1, str2));
    }
}
