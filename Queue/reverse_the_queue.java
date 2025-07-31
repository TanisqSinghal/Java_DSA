import java.util.*;

public class reverse_the_queue {

    public static void reverse(Queue<Integer> q){
        if(q.isEmpty()) {
            return;
        }

        int front = q.remove();
        reverse(q);
        q.add(front);
    }
    public static void main(String args[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        reverse(q);
        while(!q.isEmpty()) {
            System.out.print(q.remove()+" ");
        }
    }
}
