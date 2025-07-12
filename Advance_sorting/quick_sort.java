public class quick_sort {

    public static void quickSort(int arr[], int si, int ei) {
        if (si < ei) {
            int pivotIndex = partition(arr, si, ei);
            // Recursively sort elements before and after partition
            quickSort(arr, si, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, ei);
        }
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei]; // Choosing the last element as pivot
        int i = si - 1; // Index of smaller element
        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        // Swap arr[i + 1] and arr[ei] (or pivot)
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i; // Return the partition index
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println("Given array:");
        printArray(arr);
        quickSort(arr, 0, arr.length - 1);
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
