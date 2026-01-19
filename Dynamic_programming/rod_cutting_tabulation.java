public class rod_cutting_tabulation {
    //TC - O(N * W)
    public static int rodCuttingTabulation(int val[], int wt[], int W) {
        int dp[][] = new int[val.length+1][W+1];
        for(int i=0; i<dp.length; i++) {
            dp[i][0] = 0;
        }

        for(int j=0; j<dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for(int i=1; i<val.length+1; i++) {
            for(int j=1; j<W+1; j++) {
                int v = val[i-1];
                int w = wt[i-1];

                if(w <= j) {
                    int incProfit = v + dp[i][j-w]; 
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                }
                else {
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
            }
        }

        print(dp); //dp arrat will look like this

        return dp[val.length][W];
    }

    public static void print(int dp[][]) {
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int length[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int rodLength = 8;

        System.out.println(rodCuttingTabulation(price, length, rodLength));
    }
}
