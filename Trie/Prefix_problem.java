public class Prefix_problem {

    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        int freq;

        public Node() {
            for(int i=0; i<26; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) { //O(L) where L = length of word
        Node curr = root;
        for(int level=0; level<word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (idx < 0 || idx >= 26) {
            // handle non-lowercase, here we break
            return;
            }
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } else {
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String word) { //O(L)
        Node curr = root;
        for(int length=0; length<word.length(); length++) {
            int idx = word.charAt(length) - 'a';
            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.eow == true;
    }

    public static boolean wordBreak(String key) {
        if (key == null || key.isEmpty()) return false;
        if(key.length() == 0) {
            return true;
        }
        for(int i=1; i<key.length(); i++) {
            if(search(key.substring(0,i)) && 
                wordBreak(key.substring(i))) {
                    return true;
            }
        }

        return false;
    }

    public static void prefixProblem(String key) { //O(L) of this , but whole problem with array of string takes O(n * L)
        if (key == null || key.isEmpty()) return;

        Node curr = root;

        for(int length=0; length<key.length(); length++) {
            int idx = key.charAt(length) - 'a';

            System.out.print(key.charAt(length));

            if(curr.children[idx].freq == 1) {
                return;
            }

            curr = curr.children[idx];
        }
    }

    //approach 2 of prefix problem (more efficient) O(L)
    public static void prefixProblem2(Node root, String ans) {

        if(root == null) {
            return;
        }

        if(root.freq == 1) {
            System.out.println(ans);
            return;
        }
        for(int i=0; i<root.children.length; i++) {
            if(root.children[i] != null) {
                prefixProblem2(root.children[i], ans+(char)(i+'a'));
            }
        }
    }

    public static void main(String[] args) {
        String arr[] = {"zebra", "dog", "duck", "dove"};
        for(String word : arr) {
            insert(word);
        }
        root.freq = -1;
        // for(String word : arr) {
        //     prefixProblem(word);
        //     System.out.println();
        // }
        prefixProblem2(root, "");
    }
}