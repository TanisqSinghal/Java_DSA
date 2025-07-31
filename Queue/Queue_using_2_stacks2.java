import java.util.Stack;

public class Queue_using_2_stacks2 {
    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty() && s2.isEmpty();
        }

        public static void add(int data) {
            s1.push(data);
        }

        public static int remove() {
            if (isEmpty()) {
                return -1;
            }
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            int front = s2.pop();
            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return front;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            int front = s2.peek();
            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return front;
        }
    }

    public static void main(String arg[]) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
