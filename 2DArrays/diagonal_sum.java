
public class diagonal_sum {

    public static int diagonalSum(int arr[][]) {
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            sum = sum + arr[i][i];
            if(i != arr.length-i-1)
                sum = sum + arr[i][arr.length-i-1];
        }
        return sum;
    }

    public static void main(String args[]) {
        int arr[][] =  {{1,2,3},
                        {5,6,7},
                        {9,10,11}};
        System.out.println(diagonalSum(arr));
    }
}
