import java.util.ArrayList;

public class Activity_selection {
    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 8, 9, 9};

        int maxAct = 1;
        int lastEnd = end[0];
        ArrayList<Integer> act = new ArrayList<>();
        act.add(0);

        for(int i=1; i<start.length; i++) {
            if(start[i] >= lastEnd) {
                maxAct++;
                lastEnd = end[i];
                act.add(i);
            }
        }

        System.out.println("max activity possible: "+maxAct);
        for(int i=0; i<act.size(); i++){
            System.out.print("A"+act.get(i)+" ");
        }
    }
}
