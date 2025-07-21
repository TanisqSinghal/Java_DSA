
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
    public static int size = 0;

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

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
    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next; //+1
            fast = fast.next.next; // +2
        }

        return slow;
    }

    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head1 != null && head2 != null) {
            if(head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
            
        }
        while(head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    public Node mergeSort(Node head) {
        if(head == null || head.next == null) return head;
        //find mid
        Node mid = getMid(head);
        Node righthead = mid.next;
        mid.next = null;
        //Left and Right mergeSort
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(righthead);
        //merge

        return merge(newLeft, newRight);
    }

    public void zigZag() {
        //find mid
        Node mid = getMid(head);

        //reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //perform zig-zag merge
        Node right = prev;
        Node left = head;
        Node nextL, nextR;
        while(left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }

    }
    public void print() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String args[]) {
        // head = new Node(0);
        // head.next = new Node(1);
        // head.next.next = new Node(2);
        // head.next.next.next = new Node(3);
        // head.next.next.next.next = head; // 0 -> 1 -> 2 -> 3 -> 0
        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());
        Linked_List ll = new Linked_List();
        // ll.addLast(4);
        // ll.addLast(3);
        // ll.addLast(2);
        // ll.addLast(1);
        // ll.print();
        // ll.head = ll.mergeSort(ll.head);
        // // ll.addLast(5);
        // // ll.print();
        // // ll.zigZag();
        // ll.print();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.print();
        ll.zigZag();
        ll.print();
    }
}
