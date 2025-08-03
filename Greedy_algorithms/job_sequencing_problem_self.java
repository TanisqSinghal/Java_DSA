import java.util.*;

public class job_sequencing_problem_self {
    public static void main(String[] args) {
        int jobs[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};

        Arrays.sort(jobs, Comparator.comparingDouble(o -> o[1]));
        // ArrayList<Integer> jobIdx = new ArrayList<>();

        int maxProfit = jobs[jobs.length-1][1];
        int lastTimeUnit = jobs[0][0];
        // jobIdx.add(0);
        for(int i=jobs.length-1; i>=1; i--) {
            if(jobs[i][0] > lastTimeUnit) {
                maxProfit += jobs[i][1];
                lastTimeUnit = jobs[i][0];
                // jobIdx.add(i);
            }
        }
        System.out.println("max Profit: "+maxProfit);
        // for(int i=0; i<jobIdx.size(); i++) {
        //     System.out.print(jobIdx.get(i)+" ");
        // }
        
    }
}
