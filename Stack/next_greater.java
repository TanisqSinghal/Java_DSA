import java.util.*;
public class next_greater {

    public static void nextGreater(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int nextgrt[] = new int[arr.length];
        for(int i=arr.length-1; i >= 0; i--) {
            while(!s.isEmpty() && arr[i] >= arr[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nextgrt[i] = -1;
            } else {
                nextgrt[i] = arr[s.peek()];
            }
            s.push(i);
        }
        for(int i=0; i<nextgrt.length; i++) {
            System.out.print(nextgrt[i]+" ");
        }
    }

    public static void main(String args[]) {
        int arr[] = {6, 8, 0, 1, 3};
        nextGreater(arr);
        
    }
}
