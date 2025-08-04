import java.util.*;

public class Queue_assignment {
    // Question 1 - TC - O(N), SC - O(N)
    static void generatePrintBinary(int n) {
        Queue<String> q = new LinkedList<String>();
        q.add("1");
        for (int i = 0; i < n; i++) {
            String current = q.remove();
            System.out.print(current + " ");
            q.add(current + "0");
            q.add(current + "1");
        }
    }

    //Quetsion 3 - This question can not be solved by queue , this question is solved by greedy approach , by using comparators
    //TC - O(N), SC - O(N)
    public static class Job {
        int deadline;
        int profit;
        int id;

        public Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void jobSequanceProblem(int jobsInfo[][]) {

        ArrayList<Job> jobs = new ArrayList<>();

        for(int i=0; i<jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;

        for(int i=0; i<jobs.size(); i++) {
            Job curr = jobs.get(i);
            if(curr.deadline > time) {
                time++;
                seq.add(curr.id);
            }
        }

        System.out.println("max jobs: "+seq.size());
        for(int i=0; i<seq.size(); i++) {
            System.out.print(seq.get(i)+" ");
        }
    }

    // Question 4
    //TC - O(N), SC - O(K)
    public static void reverseFirstKOfQueue(Queue<Integer> q, int k) {
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < k; i++) { // k times
            s.push(q.remove());
        }

        while (!s.isEmpty()) { // k times
            q.add(s.pop());
        }

        int size = q.size();
        for (int i = 0; i < size - k; i++) { //n - k times
            q.add(q.remove());
        }
    }

    //Question 5
    public static ArrayList<Integer> maxOfSubArrays(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        if(arr.length == 0) {
            return result;
        }
        for(int i=0; i<arr.length; i++) {
            //remove the extra window from the deque , window length should be == k
            while(!dq.isEmpty() && dq.getFirst() <= i-k ) {
                dq.removeFirst();
            }

            //remove the last element from the deque if the current array element is greater then it  
            while(!dq.isEmpty() && arr[i] > arr[dq.getLast()]) {
                dq.removeLast();
            }

            //add elements in deque
            dq.addLast(i);

            //
            if(i >= k-1) {
                result.add(arr[dq.getFirst()]);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        // int n = 10;
        // generatePrintBinary(n);
        // Queue<Integer> q = new LinkedList<>();
        // q.add(10);
        // q.add(20);
        // q.add(30);
        // q.add(40);
        // q.add(50);
        // q.add(60);
        // q.add(70);
        // q.add(80);
        // q.add(90);
        // q.add(100);
        // int k = 5;
        // reverseFirstKOfQueue(q, k);
        // while(!q.isEmpty()) {
        //     System.out.print(q.remove()+" ");
        // }
        // int jobsInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};
        // jobSequanceProblem(jobsInfo);
        int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;
        System.out.println(maxOfSubArrays(arr, k));
    }
}
