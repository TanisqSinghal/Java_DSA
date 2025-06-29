public class print_largest_string {
    //print the largest strinf in the array but in LEXICOGRAPHICAL ORDER
    public static String printLargest(String arr[]) {
        String largest = arr[0];
        for(int i=1; i<arr.length; i++) {
            if(largest.compareTo(arr[i]) < 0) { //return the largest string in lexographical order
                largest = arr[i];
            }
        }
        return largest;
    }
    public static void main(String args[]) {
        String arr[] = {"apple", "mango", "banana"};
        System.out.println(printLargest(arr));
    } 
}
