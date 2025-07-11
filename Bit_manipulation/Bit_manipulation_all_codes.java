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
    public static int updateIthbit(int n, int i, int newBit) {
        n = clearIthbit(n, i);
        int bitMask = newBit << i;
        return n | bitMask;
    }
    public static int clearLastIthbits(int n, int i) {
        int bitMask = -1 << i;
        return n & bitMask;
    }
    public static int clearIthbitsInrange(int n, int i, int j) {
        int a = -1 << j+1;
        int b = (1 << i) - 1;
        int bitMask = a | b;
        return n & bitMask;
    }
    public static boolean isPowerOfTwo(int n) {
        return (n & (n-1)) == 0;
    }
    public static int countSetBits(int n) {
        int count = 0;
        while(n > 0) {
            if((n & 1) == 1) {
                count++;
            }
           n = n >> 1;
        }
        return count;
    }
    public static int fastExpo(int a, int n) {
        int ans = 1;

        while(n > 0) {
            if((n & 1) != 0) {
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }
    // public static int fastExpo(int n, int b) {
    //     return n;
    // }
    public static void main(String args[]) {
        oddOreven(6);
        System.out.println(getIthbit(15, 2));
        System.out.println(setIthbit(15, 4));
        System.out.println(clearIthbit(10, 1));
        System.out.println(updateIthbit(10, 2, 1));
        System.out.println(clearLastIthbits(15, 2));
        System.out.println(clearIthbitsInrange(10, 2, 4));
        System.out.println(isPowerOfTwo(16));
        System.out.println(countSetBits(10));
        System.out.println(fastExpo(5, 3));
        System.out.println(fastExpo(5, 3));
    }
}
