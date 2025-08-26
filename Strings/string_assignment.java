import java.util.Set;

public class string_assignment {

    // Q1 , TC - O(N), SC - O(1)
    public static int countVowels(String str) {
        int count = 0;
        // 1st approach
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' ||
                    str.charAt(i) == 'e' ||
                    str.charAt(i) == 'i' ||
                    str.charAt(i) == 'o' ||
                    str.charAt(i) == 'u') {
                count++;
            }
        }
        // 2nd appraoch
        str = str.toLowerCase(); // we don’t worry about uppercase

        for (int i = 0; i < str.length(); i++) {
            if ("aeiou".indexOf(str.charAt(i)) != -1) {
                count++;
            }
        }
        // 3rd approach
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        for (char c : str.toLowerCase().toCharArray()) {
            if (vowels.contains(c)) {
                count++;
            }
        }
        return count;
    }

    public static void checkStrings() {
        String str = "ShradhaDidi";
        String str1 = "ApnaCollege";
        String str2 = "ShradhaDidi";

        System.out.println(str.equals(str1) + " " + str.equals(str2));
    }

    public static void check() {
        String str = "ApnaCollege".replace("1", "");
        System.out.println(str);
    }

    // Q4 , TC - O(N) , SC - O(26)
    public static boolean validAnagram(String str1, String str2) {
        int arr[] = new int[26];
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            arr[str1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < str2.length(); i++) {
            arr[str2.charAt(i) - 'a']--;
            if (arr[str2.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    // Q5 - READ ABOUT .intern() method and StringBuffer

    /*
     * .intern() method - In Java, strings are special. They are stored in a String
     * Pool (inside the heap memory).
     * It makes sure that there is only one copy of each distinct string literal in
     * the string pool.
     * If you call .intern() on a string:
     * If the string already exists in the pool → it returns the reference to that
     * pooled string.
     * If not, it adds the string to the pool and returns the pooled reference.
     * For ex -
     * public class InternExample {
     * public static void main(String[] args) {
     * String s1 = "hello";
     * String s2 = new String("hello"); // new object in heap
     * 
     * System.out.println(s1 == s2); // false (different references)
     * System.out.println(s1 == s2.intern()); // true (same reference from pool)
     * }
     * }
     * Without .intern(), "hello" and new String("hello") are different objects.
     * With .intern(), both point to the same pooled string.
     * 
     * Note: Normally, you don’t need .intern() unless you’re optimizing memory
     * (lots of duplicate strings).
     */


     
    /*
     * StringBuffer -
     * In Java, String is immutable → once created, you can’t change it.
     * So, operations like concatenation (+) create new string objects every time.
     * 
     * StringBuffer is a mutable sequence of characters
     * 
     * You can modify it without creating new objects.
     * 
     * Provides methods like .append(), .insert(), .delete(), .reverse().
     * 
     * Thread-safe → methods are synchronized (safe for multithreaded use).
     * Difference between String, StringBuffer, and StringBuilder
     * | Feature       | String (Immutable)             | StringBuffer (Mutable + Thread-Safe) | StringBuilder (Mutable, Faster, Not Thread-Safe) |
    | ------------- | ------------------------------ | ------------------------------------ | ------------------------------------------------ |
    | Mutability    | ❌ No                           | ✅ Yes                                | ✅ Yes                                            |
    | Performance   | Slow (new object every change)   | Slower (because synchronized)        | Fastest (no synchronization overhead)            |
    | Thread Safety | ✅ Safe                         | ✅ Safe                               | ❌ Not Safe                                       |

    Use String → when data is fixed or small changes.
    Use StringBuffer → when working with strings in multi-threaded code.
    Use StringBuilder → when working with strings in single-threaded code (faster).
     */

    public static void main(String[] args) {
        // String str = "Tanishak";
        // System.out.println(countVowels(str));
        // checkStrings();
        // check();
        // System.out.println(validAnagram("tanishak", "tanIshak"));
    }
}
