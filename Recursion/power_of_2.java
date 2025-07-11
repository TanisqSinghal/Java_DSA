public class power_of_2 {

    public static int pow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        
        int halfpow = pow(x, n / 2);
        
        if (n % 2 == 0) {
            return halfpow * halfpow;
        } else {
            return x * halfpow * halfpow;
        }
    }

    public static void main(String[] args) {
        System.out.println(pow(2, 9));
    }
}