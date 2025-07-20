public class Linked_List {

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

    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void removeCycle() {
        boolean cycle = false;
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }
        // If the cycle starts at head
        // Step 2: Remove the cycle
        if (cycle) {
            slow = head;

            // If the cycle starts at head
            if (slow == fast) {
                // Move fast until fast.next == slow
                while (fast.next != slow) {
                    fast = fast.next;
                }
            } else {
                // Move both pointers one step at a time
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
            }

            // Step 3: Break the cycle
            fast.next = null;
        } else {
            System.out.println("This is not cyclic LL");
        }
    }

    public static void main(String args[]) {
        head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = head; // 0 -> 1 -> 2 -> 3 -> 0
        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());
    }
}
