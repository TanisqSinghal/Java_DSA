public class print_subarrays {

    // public static void print(int arr[]) {
    // for(int i=0; i<arr.length; i++) {
    // System.out.print("{" + arr[i] + "," + "}");
    // }
    // }

    public static void printSubArrays(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for(int k=i; k<=j; k++) {
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5 };
        printSubArrays(arr);
    }
}
