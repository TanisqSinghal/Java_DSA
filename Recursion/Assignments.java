public class Assignments {


    public static void findOcc(int arr[],int key, int i) {
        if(i == arr.length) return;
        if(arr[i] == key) System.out.print(i+" ");
        findOcc(arr, key, i+1);
    }

    public static StringBuilder print(int num, StringBuilder str) {

        if(num == 0) return str;
        print(num/10, str);
        int LD = num % 10;
        if(LD == 0) str.append("zero ");
        else if(LD == 1) str.append("one ");
        else if(LD == 2) str.append("two ");
        else if(LD == 3) str.append("three ");
        else if(LD == 4) str.append("four ");
        else if(LD == 5) str.append("five ");
        else if(LD == 6) str.append("six ");
        else if(LD == 7) str.append("seven ");
        else if(LD == 8) str.append("eight ");
        else if(LD == 9) str.append("nine ");
        return str;
    }

    public static int length(StringBuilder str,int idx, int len) {
        if(idx == str.length()) {
            return len;
        }
        len++;
        return length(str, idx+1, len);
    }

    public class SubstringCounter {

    public static int countSubstrings(String str, int start, int end) {
        // Base case: if substring length is 0 or invalid
        if (start > end) return 0;

        // Recursive step:
        int count = countSubstrings(str, start + 1, end)  // Exclude current start
                  + countSubstrings(str, start, end - 1)  // Exclude current end
                  - countSubstrings(str, start + 1, end - 1);  // Avoid double count

        // If characters at both ends match, it's a valid substring
        if (str.charAt(start) == str.charAt(end)) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        String S = "abcab";
        int result = countSubstrings(S, 0, S.length() - 1);
        System.out.println("Total valid substrings: " + result); // Output: 7
    }
}


    public static void towerOfHanoi(int n, String src, String hlpr, String dest) {
        if(n == 1) {
            System.out.println("transfer disk "+n+" from "+src+" to "+dest);
            return;
        }
        towerOfHanoi(n-1, src, dest, hlpr);
        System.out.println("transfer disk "+n+" from "+src+" to "+dest);
        towerOfHanoi(n-1, hlpr, src, dest);
    }

    public static void main(String args[]) {
        // int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        // int num = 2019;
        // StringBuilder str = new StringBuilder("");
        //findOcc(arr,2, 0);
        // if(num == 0) str.append("zero");
        // else print(num, str);

        // System.out.println(str);
        // StringBuilder str1 = new StringBuilder("");
        // System.out.println(length(str1, 0, 0));
        towerOfHanoi(3, "Source", "Helper", "Destination");

    }
}
