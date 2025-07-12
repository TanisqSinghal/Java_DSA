public class Tiling_problem {

    public static int tilingProblem(int n) {
        if(n == 0 || n == 1) return 1; // Base case , either 2x0 or 2x1 tiles remain at last , so return 1 way atleast
        //vertical tiles
        int vertical = tilingProblem(n-1);
        //horizontal tiles
        int horizontal = tilingProblem(n-2);
        return vertical + horizontal;
    }

    public static void main(String args[]) {
        System.out.println(tilingProblem(4));
    }
}
