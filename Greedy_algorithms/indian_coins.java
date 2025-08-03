import java.util.*;


public class indian_coins {
    public static void main(String args[]) {
        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        int amount = 590;
        int coinsUsed = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(coins, Comparator.reverseOrder());

        for(int i=0; i<coins.length; i++) {
            if(coins[i] <= amount) {
                while(coins[i] <= amount) {
                    coinsUsed++;
                    amount -= coins[i];
                    ans.add(coins[i]);
                }
            }
        }
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i)+" ");
        }
        System.out.println();
        System.out.println("count of coins: "+coinsUsed);
    }
}
