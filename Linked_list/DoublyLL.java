public class DoublyLL {

    public class node {
        int data;
        node next;
        node prev;
        
        public node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static node head;
    public static node tail;
    public int size = 0;

    public void addLast(int data) {
        node newNode = new node(data);
        if(head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        size++;
        newNode.prev = tail;
        tail = newNode;
        return;
    }
    public int removeLast() {
        if(head == null) {
            System.out.println("LL is empty");
        } else if(head.next == null) {
            int val = head.data;
            size--;
            head = tail = null;
            return val;
        }
        node temp = tail;
        size--;
        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
        return val;

    }

    public void reverse() {
        node prev = null;
        node curr = head;
        node next;

        node oldHead = head;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;


            prev = curr;
            curr = next;
        }
        head = prev;
        tail = oldHead;
    }

    public void print() {
        node temp = head;
        while(temp != null) {
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String args[]) {
        DoublyLL dll = new DoublyLL();
        dll.addLast(1);
        dll.addLast(2);
        dll.addLast(3);
        dll.addLast(4);
        dll.print();
        // dll.reverse();
        // dll.print();
        System.out.println(dll.size);
        dll.removeLast();
        dll.reverse();
        dll.print();
        System.out.println(dll.size);
    }
}
