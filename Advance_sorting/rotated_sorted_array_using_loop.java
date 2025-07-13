public class rotated_sorted_array_using_loop {

    public static int sort(int arr[], int tar) {
        int si = 0, ei = arr.length-1;
        while(si <= ei) {
            int mid = si + (ei-si)/2;
            if(arr[mid] == tar) return mid;

            //mid on L1 
            if(arr[si] <= arr[mid]) {
                //case a:
                if(arr[si] <= tar && tar <= arr[mid]) ei = mid-1;
                //case b:
                else si = mid+1;
            }
            //mid on L2
            else {
                //case a:
                if(arr[mid] <= tar && tar <= arr[ei]) si = mid+1;
                //case b:
                else ei = mid-1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {2,3,4,5,6,7,8,9,0,1};
        System.out.println(sort(arr, 0));
    }
}
