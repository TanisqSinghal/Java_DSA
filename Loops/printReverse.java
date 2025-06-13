public class printReverse {
    public static void main(String args[]) {
        int n = 10899, rev = 0;
        // while(n > 0) {
        // int lastDigit = n % 10;
        // System.out.print(lastDigit);
        // n = n/10;
        // }
        while (n > 0) {
            int lastDigit = n % 10;
            rev = rev*10 + lastDigit;
            n = n /10;
        }
        System.out.println(rev);
    }
}
