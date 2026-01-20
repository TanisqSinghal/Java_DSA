public class lcs_memo {

    public static int lcsMemo(String str1, String str2, int i, int j, int[][] dp) {
        if (i == 0 || j == 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        } else {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                dp[i][j] = lcsMemo(str1, str2, i - 1, j - 1, dp) + 1;
                return dp[i][j];
            } else {
                dp[i][j] = Math.max(lcsMemo(str1, str2, i - 1, j, dp), lcsMemo(str1, str2, i, j - 1, dp));
                return dp[i][j];
            }
        }

    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(lcsMemo(str1, str2, str1.length(), str2.length(), dp));

    }
}
