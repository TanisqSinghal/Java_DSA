public class string_conversion {
    public static int stringConversionTabu(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        dp[0][0] = 0;

        for(int i=1; i<n+1; i++) {
            dp[i][0] = i;
        }

        for(int i=1; i<m+1; i++) {
            dp[0][i] = i;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    int add = dp[i][j-1] + 1;
                    int dlt = dp[i-1][j] + 1;
                    // int replace = dp[i-1][j-1] + 1;
                    dp[i][j] = Math.min(add, dlt);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "aceg";

        System.out.println(stringConversionTabu(str1, str2));
    }
}
