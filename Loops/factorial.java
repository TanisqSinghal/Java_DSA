public class factorial {
    public static void main(String args[]) {
        int n = 4;
        int factorial = 1;
        while(n > 0) {
            factorial = factorial * n;
            n--;
        }
        System.out.println(factorial);
    }
}
