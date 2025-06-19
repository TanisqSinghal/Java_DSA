public class buy_and_sell_stocks {

    public static int bestTimeOfbuyAndsellstocks(int arr[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0; i<arr.length; i++) {
            if(buyPrice < arr[i]) {
                int Profit = arr[i] - buyPrice;
                maxProfit = Math.max(maxProfit, Profit);
            } else {
                buyPrice = arr[i];
            }
        }
        return maxProfit;
    }

    public static void main(String args[]) {
        int arr[] = {7,1,5,3,6,4};
        System.err.println(bestTimeOfbuyAndsellstocks(arr));
    }
}
