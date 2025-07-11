public class print {
    public static void printn(int n) {
        System.out.print(n + " ");
        if( n == 1) return;
        printn(n-1);
    }
    public static void printInc(int n) {
        if(n == 1) {
            System.out.print(1+" ");
            return;
        }
        printInc(n-1);
        System.out.print(n+" ");
    }

    public static void main(String args[]) {
        printInc(10);
    }
}
