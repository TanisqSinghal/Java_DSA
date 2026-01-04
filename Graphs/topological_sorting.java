import java.util.*;

public class topological_sorting {
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
    public static void topSort(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                topSortUtil(graph, i, vis, s); //DFS func
            }
        }

        while(!s.isEmpty()) {
            System.out.print(s.pop()+" ");
        }
    }
    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s) {
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr); // add at last
    }
    public static void main(String[] args) {
         @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[6];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 1, 1));

        graph[4].add(new Edge(3, 0, 1));
        graph[4].add(new Edge(3, 1, 1));
    
        graph[5].add(new Edge(3, 0, 1));
        graph[5].add(new Edge(3, 2, 1));
        topSort(graph);

    }
}
