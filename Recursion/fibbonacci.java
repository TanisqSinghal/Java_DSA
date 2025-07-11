public class fibbonacci {

    public static int fibbonacciOfN(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int fibb = fibbonacciOfN(n - 1) + fibbonacciOfN(n - 2);
        return fibb;
    }

    // public static void printFibbonacciOfN(int n) {
    //     if (n == 0) {
    //          System.out.print(0+" ");;
    //          return;
    //     } else if (n == 1) {
    //         System.out.print(1+" ");
    //         return;
    //     }
    //     int fibb = printFibbonacciOfN(n - 1) + printFibbonacciOfN(n - 2);
    //     System.out.print(fibb+" ");
    // }

    public static void main(String args[]) {
        System.out.println(fibbonacciOfN(31));
    }
}
