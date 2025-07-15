public class substring {

    public static void subStr(String str, String ans, int i) {

        if(i == str.length()) {
            System.out.println(ans);
            return;
        }

        //yes choice //TC = O(n * 2^n)
        subStr(str, ans+str.charAt(i), i+1);

        //no choice 
        subStr(str, ans, i+1);
    }

    public static void main(String args[]) {
        subStr("abc", "", 0);
    }
}
