import java.util.*;

public class sumOfFirstN {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a range: ");
        int n = sc.nextInt();
        int start = 1;
        int sum = 0;
        while(start <= n) {
            sum = sum + start;
            start++;
        }
        sc.close();
        System.out.println(sum);
    }
}
