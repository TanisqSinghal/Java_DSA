public class leapYear {
    public static void main(String args[]) {
        int year = 2024;
        boolean x = (year%4 == 0);
        boolean y = (year%100 != 0);
        boolean z = (year%100 == 0) && (year%400 == 0);

        if(x && (y || z)) {
            System.out.println("Leap year");
        } else {
            System.out.println("Not leap year");
        }
    }
}
