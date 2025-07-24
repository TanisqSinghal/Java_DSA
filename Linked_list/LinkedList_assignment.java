public class LinkedList_assignment {
    public static class node {
        int data;
        node next;

        public node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static node head;
    public static node head1;
    public static node head2;
    public static node tail;
    public int size = 0;

    public void addLast(int data) {
        node newNode = new node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print(node head) {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static int findLink() {
        node temp1 = head1;

        while (temp1 != null) {
            node temp2 = head2;
            while (temp2 != null) {
                if (temp1.data == temp2.data) {
                    return temp1.data;
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        return 0;
    }

    public void skipMdeleteN(int m, int n) {
        node curr = head;
        int count;
        while (curr != null) {
            for (count = 1; count < m && curr != null; count++) {
                curr = curr.next;
            }
            if (curr == null) {
                return;
            }
            node t = curr.next;
            for (count = 1; count < n && t != null; count++) {
                t = t.next;
            }
            curr.next = t.next;
            curr = t.next;
        }
    }

    // public void swapNodesInLL(int x, int y) {
    //     node temp1 = head;
    //     node temp2 = head;
    //     for (int count = 1; count < x - 1; count++) {
    //         temp1 = temp1.next;
    //     }
    //     for (int count = 1; count < y; count++) {
    //         temp2 = temp2.next;
    //     }
    //     node temp4 = temp1.next;
    //     node temp3 = temp2.next;
    //     temp1.next = null;
    //     temp2.next = null;

    //     node curr = temp4;
    //     node prev = null;
    //     node next;
    //     while (curr != null) {
    //         next = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr = next;
    //     }
    //     temp1.next = prev;
    //     temp4.next = temp3;
    // }

    public void swapNodesInLL(int x, int y) {
        if (x == y)
            return;

        node prevX = null, currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        node prevY = null, currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        // If either x or y is not present
        if (currX == null || currY == null)
            return;

        // If x is not head of list
        if (prevX != null)
            prevX.next = currY;
        else
            head = currY;

        // If y is not head of list
        if (prevY != null)
            prevY.next = currX;
        else
            head = currX;

        // Swap next pointers
        node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    public node segragateOddOrEven() {
        if(head == null) return null;

        node evenhead = null; node oddhead = null;
        node eventail = null; node oddtail = null;
        node curr = head;
        while(curr != null) {
            if(curr.data % 2 == 0) {
                if(evenhead == null) {
                    evenhead = eventail = curr;
                } else {
                    eventail.next = curr;
                    eventail = eventail.next;
                }
            } else {
                if(oddhead == null) {
                    oddhead = oddtail = curr;
                } else {
                    oddtail.next = curr;
                    oddtail = oddtail.next;
                }
            }
            curr = curr.next;
        }

        if(eventail != null) {
            eventail.next = oddhead;
        } 
        if(oddtail != null) {
            oddtail.next = null;
        }

        return evenhead != null ? evenhead : oddhead;
    }

    public static void main(String args[]) {
        // head1 = new node(1);
        // head1.next = new node(2);
        // head1.next.next = new node(3);
        // node temp = new node(6);
        // head1.next.next.next = temp;
        // head1.next.next.next.next = new node(7);

        // head2 = new node(4);
        // head2.next = new node(5);
        // head2.next.next = temp;
        // print(head1);
        // print(head2);
        // System.out.println(findLink());
        LinkedList_assignment ll = new LinkedList_assignment();
        ll.addLast(0);
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.print(head);
        // ll.swapNodesInLL(2, 4);
        ll.segragateOddOrEven();
        ll.print(head);
        // ll.addLast(5);
        // ll.addLast(6);
        // ll.addLast(7);
        // ll.addLast(8);
        // ll.print(head);
        // ll.skipMdeleteN(2, 2);
        // ll.print(head);
    }
}
