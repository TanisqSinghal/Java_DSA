public class counting_sort {

    public static void countingSort(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }
        int count[] = new int[largest+1];
        for(int i=0; i<arr.length; i++) {
            count[arr[i]]++;
        }
        int j=0;
        for(int i=0; i<count.length; i++) {
            while(count[i] > 0) {
                arr[j++] = i;
                count[i]--;
            }
        }
    }
    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String args[]) {
        int arr[] = {5,4,2,3,1};
        countingSort(arr);
        print(arr);
    }
}
