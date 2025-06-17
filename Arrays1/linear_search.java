public class linear_search {

    public static int linearSearch(int arr[], int key) {
        for(int i=0; i< arr.length; i++) {
            if(arr[i] == key) {
                return i;
            }
            
        }
        return -1;
    }

    public static void main(String args[]) {
        int arr1[] = {3,5,1,2,6,7};
        System.out.println(linearSearch(arr1, 2));
    }
}
