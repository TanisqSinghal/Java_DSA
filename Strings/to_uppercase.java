public class to_uppercase {

    public static StringBuilder UpperCase(String str) {
        int n = str.length();
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<n; i++) {
            char ch = str.charAt(i);
            if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                ch = (char)(ch - 'a' + 'A');
            }
            sb.append(ch);
        }
        return sb;
    }

    public static void main(String args[]) {
        String str = "hi, i am tanishak";
        System.out.println(UpperCase(str));
        System.out.println(str.toUpperCase());
    }
}
