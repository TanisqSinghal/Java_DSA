
public class check_for_palindrome {

    public static boolean paindrome(String str) {
        int start = 0, end = str.length()-1;
        while(start <= end) {
            if(str.charAt(start) != str.charAt(end)) {
                return false;
            } 
            start++;
            end--;
        }
        return true;

    }

    public static void main(String args[]) {
    String str = "Tanishak";
    System.out.println(paindrome(str));
    }     
}
