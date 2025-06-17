public class binary_search {

    public static int binarySearch(int arr[], int key) {
        int start = 0, end = arr.length-1;
        for(int i=0; i<arr.length; i++){
            int mid = (start+end)/2;
            if(arr[mid] == key) {
                return mid;
            }
            if(arr[mid] > key) {
                end = mid-1;
            }
            if(arr[mid] < key) {
                start = mid+1;
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        int arr[] = {1,2,3,4,5,6,7};
        System.out.println(binarySearch(arr, 9));
    }
}
