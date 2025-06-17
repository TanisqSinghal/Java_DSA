public class floyads_triangle {

    public static void floyds_triangle(int n) {
        int m = 1;
        for(int i = 1; i <= n ; i++) {
            for(int j = 1; j <= i; j++) {
               System.out.print(m++ + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        floyds_triangle(5);
    }
}
