public class Linkedlist {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node Head;
    public static Node Tail;
    public int size = 0;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if(Head == null) {
            Head = Tail = newNode;
            return;
        }
        newNode.next = Head;
        Head = newNode;
    }
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(Head == null) {
            Head = Tail = newNode;
            return;
        }
        Tail.next = newNode;
        Tail = newNode;
    }
    public void add(int idx, int data) {
        if(idx == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;
        Node temp = Head;
        int i = 0;
        while(i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public int removeFirst() {
        if(size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = Head.data;
            Head = Tail = null;
            size = 0;
            return val;
        }
        int val = Head.data;
        Head = Head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if(size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = Tail.data;
            Head = Tail = null;
            size = 0;
            return val;
        }
        int val = Tail.data;
        Node temp = Head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        Tail = temp;
        Tail.next = null;
        size--;
        return val;
    }
    public void print() {
        Node temp = Head;
        while(temp != null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String args[]) {
        Linkedlist ll = new Linkedlist();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(5);
        ll.add(3, 4);
        ll.removeFirst();
        ll.removeLast();;
        ll.print();
        System.out.println(ll.size);
    }
}
