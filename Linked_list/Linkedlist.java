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

    public int itrSearch(int target) {
        Node temp = Head;
        int i = 0;
        while(temp != null) {
            if(temp.data == target) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int helper(Node temp, int key) {
        if(temp == null) {
            return -1;
        }
        if(temp.data == key) {
            return 0;
        }
        int idx = helper(temp.next, key);
        if(idx == -1) {
            return -1;
        }
        return idx+1;
    }

    public int recSearch(int key) {
        return helper(Head, key);
    }

    public void reverse() {
        Node prev = null;
        Node curr = Tail = Head;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Head = prev;
    }

    public void delete(int n) { // position should be start with 1 
        if(n == 1) {
            Head = Head.next;
            return;
        }
        Node prev = Head;
        for(int i=0; i<n-2; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        size--;
        return;
    }

    public boolean isPalindrome() {
        Node mid = Head;
        for(int i=0; i<(size/2); i++) {
            mid = mid.next;
        }
        Node prev = null;
        Node curr = mid;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node secondHalf = prev;
        Node firstHalf = Head;
        boolean isPalin = true;
        Node temp = secondHalf;

        while (temp != null) {
            if (firstHalf.data != temp.data) {
                isPalin = false;
                break;
            }
            firstHalf = firstHalf.next;
            temp = temp.next;
        }
        curr = prev;
        prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return isPalin;
    }

    public static void main(String args[]) {
        Linkedlist ll = new Linkedlist();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(1);
        // ll.add(3, 4);
        // ll.removeFirst();
        // ll.removeLast();
        ll.print();
        // System.out.println(ll.recSearch(3));
        // ll.reverse();
        // ll.print();
        // ll.delete(0);
        // ll.print();
        System.out.println(ll.isPalindrome());
        // System.out.println(ll.size);
        ll.print();
    }
}
