public class factorial {
    public static void main(String args[]) {
        System.out.println(nfactorial(0));
    }
    public static int nfactorial(int n) {
        if(n == 1 || n == 0) {
            return 1;
        }

        return n * nfactorial(n-1);
    }
}
