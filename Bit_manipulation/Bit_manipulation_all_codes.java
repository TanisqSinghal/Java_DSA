public class Bit_manipulation_all_codes {

    public static void oddOreven(int n) {
        int bitMask = 1;
        if((n & bitMask) == 0) {
            System.out.println("even");
        } else {
            System.out.println("odd");
        }
    }
    public static int getIthbit(int n, int i) {
        int bitMask = 1 << i;
        if((n & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }
    public static int setIthbit(int n, int i) {
        int bitMask = 1 << i;
        return n | bitMask;
    }
    public static int clearIthbit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }
    public static void main(String args[]) {
        // oddOreven(6);
        // System.out.println(getIthbit(15, 2));
        // System.out.println(setIthbit(15, 4));
        System.out.println(clearIthbit(10, 1));
    }
}
