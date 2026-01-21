public class wildcard_matching {

    public static boolean wildcardMatching(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();


        boolean dp[][] = new boolean[n+1][m+1];
        dp[0][0] = true;

        for(int i=1; i<n+1; i++) {
            dp[i][0] = false;
        }
        for(int i=1; i<m+1; i++) {
            if(str2.charAt(i-1) == '*') {
                dp[0][i] = dp[0][i-1];
            }
        }


        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1) || str2.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(str2.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
                else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
        
    }

    public static void main(String[] args) {
        String str1 = "baaabab";
        String str2 = "*****ba*****ab";

        System.out.println(wildcardMatching(str1, str2));

    }
}
