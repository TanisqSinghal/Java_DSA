public class to_uppercase {

    public static String toUpperCase(String str) {
        int n = str.length();
        for(int i=0; i<n; i++) {
            char ch = str.charAt(i);
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                continue;
            } else {
                str.charAt(i) = ch - 'a' + 'A';
            }
        }
    }

    public static void main(String args[]) {
        String str = "hi, i am tanishak";
    
    }
}
