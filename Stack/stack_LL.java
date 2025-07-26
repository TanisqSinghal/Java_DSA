public class stack_LL {

    public static class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static node head = null;

    boolean isEmpty() {
        return head == null;
    }

    void push(int data) {
        node newNode = new node(data);
        newNode.next = head;
        head = newNode;
    }

    int pop() {
        if (isEmpty()) {
            return -1;
        }

        int val = head.data;
        head = head.next;
        return val;
    }

    int peek() {
        if (isEmpty()) {
            return -1;
        }
        return head.data;
    }

    public static void main(String args[]) {
        stack_LL s = new stack_LL();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
