public class primeOrNot {
    public static void main(String args[]) {
        int n = 173, sum = 0;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                sum = sum + 1;
                if (sum >= 2)
                    break;
            }
        }
        if (n == 0 || n == 1) {
            System.out.println("Not Prime");
        } else if (sum >= 2) {
            System.out.println("Not Prime");
        } else {
            System.out.println("Prime");
        }
    }
}
