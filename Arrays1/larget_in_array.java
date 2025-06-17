public class larget_in_array {

    public static int largetNum(int arr[]) {
        int max = arr[0];
        for(int i=0; i<arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String args[]) {
        int arr[] = {1,2,45,34,122};
        System.out.println(largetNum(arr));
    }
}
