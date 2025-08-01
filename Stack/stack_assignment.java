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

    public static void main(String[] args) {
        // Linked_List ll = new Linked_List();
        // ll.addLast('A');
        // ll.addLast('B');
        // ll.addLast('C');
        // ll.addLast('B');
        // ll.addLast('B');
        // ll.print();
        // System.out.println(ll.isPalin(ll));
        String path = "/a/./b/../../c";
        System.out.println(simplifyPath(path));
    }
}
