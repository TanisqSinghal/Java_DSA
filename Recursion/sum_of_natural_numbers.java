public class sum_of_natural_numbers {

    public static int sum(int n) {
        if(n == 1) return 1;
        return n + sum(n-1);
    }

    public static void main(String args[]) {
        System.out.println(sum(5));
    }
}
