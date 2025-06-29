public class to_uppercase {

    // public static StringBuilder UpperCase(String str) {
    // int n = str.length();
    // StringBuilder sb = new StringBuilder("");
    // for(int i=0; i<n; i++) {
    // char ch = str.charAt(i);
    // if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
    // ch = (char)(ch - 'a' + 'A');
    // }
    // sb.append(ch);
    // }
    // return sb;
    // }
    public static String capitalize(String str) {
        StringBuilder sb = new StringBuilder("");

        boolean capitalizeNext = true;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                sb.append(ch);
                capitalizeNext = true; // next non-space should be capitalized
            } else if (capitalizeNext) {
                sb.append(Character.toUpperCase(ch));
                capitalizeNext = false;
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        String str = " hi, i am tanishak";
        System.out.println(capitalize(str));
    }
}
