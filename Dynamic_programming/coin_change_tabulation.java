public class coin_change_tabulation {

    public static int coinChangeTabulation(int coin[], int sum) {
        int dp[][] = new int[coin.length+1][sum+1];

        for(int i=0; i<=coin.length; i++) {
            dp[i][0] = 1;
        }

        for(int i=1; i<coin.length+1; i++) {
            for(int j=1; j<sum+1; j++) {
                if(coin[i-1] <= j) { //valid case
                    dp[i][j] = dp[i][j-coin[i-1]] + dp[i-1][j];
                }
                else { //invalid case
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[coin.length][sum];
    }

    public static void main(String[] args) {
        int coin[] = {2, 5, 3, 6};
        int sum = 10;

        System.out.println(coinChangeTabulation(coin, sum));
    }
}
