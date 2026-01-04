import java.util.*;

public class top_sort_using_bfs {
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

    public static void calcInDeg(ArrayList<Edge>[] graph, int[] inDeg) {
        for(int i=0; i<graph.length; i++) {
            for(int j=0; j<graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                inDeg[e.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge>[] graph) {
        int[] inDeg = new int[graph.length];
        calcInDeg(graph, inDeg);
        Queue<Integer> q = new LinkedList<>();

    
        for(int i=0; i<inDeg.length; i++) {
            if(inDeg[i] == 0) {
                q.add(i);
            }
        }

        //bfs
        while(!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr+" ");

            for(int i=0; i<graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                inDeg[e.dest]--;

                if(inDeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
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
        /*
            2----->3----->1<------4------>0
                          ▲               ▲
                          |               |
                          |               |
                          ----------------5
        */
        topSort(graph);
    }
}
