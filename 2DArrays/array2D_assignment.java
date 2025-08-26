public class array2D_assignment {
    //Q1 , TC - O(N^2), SC - O(1)
    public static int findNumberOf7(int[][] arr) {
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                if(arr[i][j] == 7) {
                    count++;
                }
            }
        }
        return count;
    }
    //Q2 , TC - O(N), SC - O(1)
    public static int secondRowSum(int[][] arr) {
        int sum = 0;
        for(int i=0; i<arr[0].length; i++) {
            sum += arr[1][i];
        }
        return sum;
    }
    //Q3 , TC - O(N^2), SC - O(N^2)
    public static int[][] transpose(int[][] matrix) {
        int arr[][] = new int[matrix[0].length][matrix.length];
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                arr[i][j] = matrix[j][i];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[][] =  {{4,7,8},{8,8,7}};
        System.out.println(findNumberOf7(arr));
        System.out.println(secondRowSum(arr));
        System.out.println(transpose(arr));
    }
}
