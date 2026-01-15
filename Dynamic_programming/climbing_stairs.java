public class climbing_stairs {

    public static int climbingStairs(int n) { //TC - O(2^N)
        if(n == 0) {
            return 1;
        }
        else if(n < 0) {
            return 0;
        }

        return climbingStairs(n-1) + climbingStairs(n-2);
    }
    public static void main(String[] args) {
        System.out.println(climbingStairs(4));
    }
}
