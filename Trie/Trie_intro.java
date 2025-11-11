public class Trie_intro {

    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        public Node() {
            for(int i=0; i<26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) { //O(L) where L = length of word
        Node curr = root;
        for(int length=0; length<word.length(); length++) {
            int idx = word.charAt(length) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
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
    public static void main(String[] args) {
        String words[] = {"the", "a", "there", "their", "any", "thee"};
        for(String word : words) {
            insert(word);
        }
        System.out.println(search("the"));
        System.out.println(search("any"));
        System.out.println(search("thor"));
        System.out.println(search("an"));
    }
}
