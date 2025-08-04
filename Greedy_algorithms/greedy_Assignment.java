import java.util.Arrays;
import java.util.Comparator;

public class greedy_Assignment {

    // Question 1
    public static int maxBalStrPart(String str) {
        int balance = 0;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'L') {
                balance--;
            } else {
                balance++;
            }
            if (balance == 0) {
                count++;
            }
        }
        return count;
    }

    // Question 2
    public static int kthLargestOdd(int L, int R, int k) {
        if (L % 2 == 0) {
            L -= 1; // smallest odd number
        }

        if (R % 2 == 0) {
            R -= 1; // largest odd number
        }

        if (L > R) {
            return 0; // no number exist
        }

        int count = ((R - L) / 2) + 1;

        if (k > count) {
            return 0;
        }

        return (R - 2 * (k - 1));
    }

    // Question 3
    public static String smallestLexoStringOfLenN(int n, int k) {
        char result[] = new char[n];

        for (int i = 0; i < result.length; i++) {
            result[i] = 'a';
        }

        k = k - n;

        int i = n - 1;
        while (k > 0) {
            int space = Math.min(k, 25);
            result[i] += space;
            k -= space;
            i--;
        }

        return new String(result);
    }

    // Question 4
    public static int bestTimetoBuyAndSellStocks(int price[]) {
        int sortedPrice[][] = new int[price.length][2];

        for (int i = 0; i < price.length; i++) {
            sortedPrice[i][0] = i;
            sortedPrice[i][1] = price[i];
        }

        Arrays.sort(sortedPrice, Comparator.comparingDouble(o -> o[1]));

        int lastDay = sortedPrice[0][0];
        int buyPrice = sortedPrice[0][1];
        int maxProfit = 0;
        for (int i = 1; i < sortedPrice.length; i++) {
            if (sortedPrice[i][0] > lastDay) {
                int profit = sortedPrice[i][1] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
    //Question 4 - approach 2(more optimal)
    public static int bestTimetoBuyAndSellStocks2(int price[]) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < price.length; i++) {
            minPrice = Math.min(minPrice, price[i]);
            int profit = price[i] - minPrice;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // String str = "LRRRRLLRLLRL";
        // System.out.println(maxBalStrPart(str));
        // System.out.println(kthLargestOdd(-3, 3, 1));
        // System.out.println(smallestLexoStringOfLenN(5, 42));
        int prices[] = { 2, 1, 4 };
        System.out.println(bestTimetoBuyAndSellStocks2(prices));
    }
}
