public class merge_sort {

    public static void mergeSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        
        int mid = (si + ei) / 2;
        
        // Sort the left half
        mergeSort(arr, si, mid);
        
        // Sort the right half
        mergeSort(arr, mid + 1, ei);
        
        // Merge the sorted halves
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si; // Starting index for left subarray
        int j = mid + 1; // Starting index for right subarray
        int k = 0; // Index for temporary array
        // Merge the two halves
        while (i <= mid && j <= ei) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // Copy any remaining elements from either half
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= ei) {
            temp[k++] = arr[j++];
        }
        // Copy the merged elements back into the original array
        for (k=0, i= si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        System.out.println("Given array:");
        printArray(arr);
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("\nSorted array:");
        printArray(arr);
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
