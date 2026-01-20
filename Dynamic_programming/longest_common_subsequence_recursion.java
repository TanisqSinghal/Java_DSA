public class longest_common_subsequence_recursion {

    public static int lcsRecursion(String str1, String str2, int i, int j) {
        if(i == 0 || j == 0) {
            return 0;
        }

        if(str1.charAt(i-1) == str2.charAt(j-1)) {
            return lcsRecursion(str1, str2, i-1, j-1) + 1;
        }
        else {
            return Math.max(lcsRecursion(str1, str2, i-1, j) , lcsRecursion(str1, str2, i, j-1));
        }

    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";

        System.out.println(lcsRecursion(str1, str2, str1.length(), str2.length()));
    }
}
