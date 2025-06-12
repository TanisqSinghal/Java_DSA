import java.util.*;

public class areaOfCircle {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        float r = sc.nextFloat();
        float Area = 3.14f * r * r;
        System.out.println(Area);
        sc.close();
    }
}
