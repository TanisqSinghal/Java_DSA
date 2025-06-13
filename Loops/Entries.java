import java.util.*;

public class Entries {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("Enter a number: ");
            int x = sc.nextInt();
            if(x % 10 == 0) {
                System.out.println("Multiple of 10 occured");
                break;
            }
            System.out.println(x);
        }
    }
}
