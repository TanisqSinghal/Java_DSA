import java.util.*;

public class stack_assignment {
    static class Linked_List {
        public static class Node {
            int data;
            Node next;

            public Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        public static Node head;
        public static Node tail;
        public static int size = 0;

        public void addLast(int data) {
            Node newNode = new Node(data);
            size++;
            if (head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        public static boolean isPalin(Linked_List ll) {
            Stack<Integer> s = new Stack<>();

            Node temp = head;

            while (temp != null) {
                s.push(temp.data);
                temp = temp.next;
            }
            temp = head;

            while (temp != null) {
                if (s.pop() != temp.data) {
                    return false;
                }
                temp = temp.next;
            }
            return true;
        }

        public void print() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    public static String simplifyPath(String path) {
        String tokens[] = path.split("/");
        Stack<String> s = new Stack<>();
        for(String token : tokens) {
            if(token.equals("")|| token.equals(".")) {
                continue;
            }
            else if(token.equals("..")) {
                if(!s.isEmpty()) {
                    s.pop();
                }
            } else {
                s.push(token);
            }
        }
        StringBuilder result = new StringBuilder("");
        while(!s.isEmpty()) {
            result.append("/").append(s.pop());
        }

        return result.length() > 0 ? result.toString() : "/";

    }

    public static String decodeString(String str) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> charStack = new Stack<>();
        String currString = "";
        int currNum = 0;

        for(char ch : str.toCharArray()) {
            if(Character.isDigit(ch)) {
                currNum = currNum * 10 + (ch - '0');
            }
            else if(ch == '[') {
                numStack.push(currNum);
                charStack.push(currString);
                currNum = 0;
                currString = "";
            }
            else if(ch == ']') {
                StringBuilder temp = new StringBuilder(charStack.pop());
                int num = numStack.pop();

                for(int i=0; i<num; i++) {
                    temp.append(currString);
                }
                currString = temp.toString();
            } 
            else {
                currString = currString + ch;
            }
        }
        return currString;
    }

    public static int trappingRainWater(int[] arr) { // didn't used stack as we have solved in O(1) SC in O(N) TC
        int leftMax = arr[0];
        int rightMax = arr[arr.length-1];
        int low = 1;
        int high = arr.length-2;
        int trappedwater = 0;

        while(low <= high) {
            if(leftMax < rightMax) {
                leftMax = Math.max(leftMax, arr[low]);
                trappedwater += leftMax-arr[low];
                low++;
            } 
            else {
                rightMax = Math.max(rightMax, arr[high]);
                trappedwater += rightMax - arr[high];
                high--;
            }
        }
        return trappedwater;
    }

    public static void main(String[] args) {
        // Linked_List ll = new Linked_List();
        // ll.addLast('A');
        // ll.addLast('B');
        // ll.addLast('C');
        // ll.addLast('B');
        // ll.addLast('B');
        // ll.print();
        // System.out.println(ll.isPalin(ll));
        // String path = "/a/./b/../../c";
        // String str1 = "2[a3[dd]c]";
        // System.out.println(simplifyPath(path));
        // System.out.println(decodeString(str1));
        int[] arr = {7, 0, 4, 2, 5, 0, 6, 4, 0, 5};
        System.out.println(trappingRainWater(arr));
    }
}
