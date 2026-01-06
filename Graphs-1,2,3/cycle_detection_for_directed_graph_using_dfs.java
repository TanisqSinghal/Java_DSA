import java.util.*;

public class cycle_detection_for_directed_graph_using_dfs {
     static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }
    }
    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++) { //for disconnected components of graph
            if(!vis[i]) {
                if(isCycleUtil(graph, i, vis, stack)) return true;
            }
        }
        return false;
    }
    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] stack) {
        vis[curr] = true;
        stack[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(stack[e.dest]) {
                return true;
            }
            if(!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }
    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[5];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        //True
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        
        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 0, 1));

        //false
        // graph[0].add(new Edge(0, 1, 1));
        // graph[0].add(new Edge(0, 2, 1));

        // graph[1].add(new Edge(1, 3, 1));
        
        // graph[2].add(new Edge(2, 3, 1));

        /*
        1 -----> 0 ------> 2
                 ▲  cycle  |
                 |   (✓)   |
                 |         ▼
                 --------- 3
        */

        System.out.println(isCycle(graph)); //true

    }
}
