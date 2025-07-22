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
        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print(node head) {
        node temp = head;
        while(temp != null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static int findLink() {
        node temp1 = head1;

        while(temp1 != null) {
            node temp2 = head2;
            while(temp2 != null) {
                if(temp1.data == temp2.data) {
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
        while(curr != null) {
            for(count = 1; count < m && curr != null; count++) {
                curr = curr.next;
            }
            if(curr == null) {
                return;
            }
            node t = curr.next;
            for(count = 1; count < n && t != null; count++) {
                t = t.next;
            }
            curr.next = t.next;
            curr = t.next;
        }
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
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.addLast(8);
        ll.print(head);
        ll.skipMdeleteN(2, 2);
        ll.print(head);
    }
}
