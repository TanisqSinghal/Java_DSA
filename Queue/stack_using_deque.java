import java.util.*;

public class stack_using_deque {

    static class Stack {
        Deque<Integer> deque = new LinkedList<>();

        public boolean isEmpty() {
            return deque.isEmpty();
        }

        public void push(int data) {
            deque.addLast(data);
        }
        public void pop() {
            deque.removeLast();
        }
        public void peek() {
            deque.getLast();
        }
    }

    public static void main(String args[]) {

    }
}
