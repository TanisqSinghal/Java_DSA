public class remove_duplicates {

    public static void removeDuplicates(String str, int idx, StringBuilder newstr, boolean map[]) {
        if(idx == str.length()) {
            System.out.println(newstr);
            return;
        }

        char currChar = str.charAt(idx);
        if(map[currChar-'a'] == true) {
            removeDuplicates(str, idx+1, newstr, map);
        } else {
            map[currChar-'a'] = true;
            removeDuplicates(str, idx+1, newstr.append(currChar), map);
        }
    }

    public static void main(String args[]) {
        String str = "appnnacollege";
        boolean map[] = new boolean[26];
        removeDuplicates(str, 0, new StringBuilder(""), map);
    }
}
