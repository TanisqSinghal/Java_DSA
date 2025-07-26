import java.util.ArrayList;

public class stack {
    static ArrayList<Integer> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void push(int data) {
        list.add(data);
    }

    public int pop() {
        int val = list.get(list.size() - 1);
        list.remove(list.size()-1);
        return val;
    }

    public int peek() {
        return list.get(list.size()-1);
    }

    public static void main(String args[]) {
        stack s = new stack();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        // System.out.println(s.pop());
        // System.out.println(s.pop());
        // System.out.println(s.pop());
        // System.out.println(s.pop());

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}