import java.util.*;
public class valid_parenthesis {

    public static boolean validParenthesis(String str) {
        Stack<Character> s = new Stack<>();
        int i = 0;
        while(i < str.length()) {
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                if(s.isEmpty()) return false;
                if((s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}') || (s.peek() == '[' && ch == ']') ) {
                    s.pop();
                } else {
                    return false;
                }
            }
            i++;
        }
        if(s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String args[]) {
        String str = "(){}[}]";
        System.out.println(validParenthesis(str));
    }
}
