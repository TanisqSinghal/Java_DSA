import java.util.Stack;

public class duplicate_parentheses {

    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();

        for(int i = 0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == ')') { // closing condition , check for duplicate
                int count  = 0;
                while(s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if(count < 1) {
                    return true; //duplicate found
                } else {
                    s.pop(); // just pop out , not duplicate found till now 
                }
            } else {
                s.push(ch); // opening condition, push in stack
            }
        }
        return false;
    }

    public static void main(String args[]) {
        String str = "((a+b))";
        // String str2 = "((a) + (b))";
        System.out.println(isDuplicate(str));
    }
}
