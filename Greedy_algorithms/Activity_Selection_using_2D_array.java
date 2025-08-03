import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Activity_Selection_using_2D_array {
    public static void main(String args[]) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        int activities[][] = new int[start.length][3];
        for(int i=0; i<start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        Arrays.sort(activities, Comparator.comparingDouble(a -> a[2]));

        int maxAct = 1;
        int lastEnd = activities[0][2];
        ArrayList<Integer> act = new ArrayList<>();
        act.add(activities[0][0]);

        for(int i=1; i<start.length; i++) {
            if(activities[i][1] >= lastEnd) {
                maxAct++;
                lastEnd = activities[i][2];
                act.add(activities[i][0]);
            }
        }

        System.out.println("max activity possible: "+maxAct);
        for(int i=0; i<act.size(); i++){
            System.out.print("A"+act.get(i)+" ");
        }
    }
}
