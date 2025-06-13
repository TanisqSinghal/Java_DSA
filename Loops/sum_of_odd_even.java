public class sum_of_odd_even {
    public static void main(String args[]) {
        int oddsum = 0, evenSum = 0;
        for(int i = 1; i <= 10; i++ ) {
            if(i % 2 == 0) evenSum = evenSum + i;
            else oddsum = oddsum + i;
        }
        System.out.println(oddsum);
        System.out.println(evenSum);
    }
}
