public class first_occurance {

    public static int first(int arr[], int key, int i) {
        if(arr[i] == key) return i;
        if(i == arr.length-1) return -1;
        return first(arr, key, i+1);
    }
    public static int lastOccurance(int arr[], int key, int i) {
        if(arr[i] == key) return i;
        if(i <= 0) return -1;
        return lastOccurance(arr, key, i-1);
    }
    public static void main(String args[]) {
        int arr[] = {1,2,1,5,3,8,4,2,8,7};
        System.out.println(lastOccurance(arr, 2, arr.length-1));
    }
}
