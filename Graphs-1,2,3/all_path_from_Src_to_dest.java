import java.util.ArrayList;

public class all_path_from_Src_to_dest {
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
    public static void printAllPath(ArrayList<Edge>[] graph, int src , int dest, String path) { // TC - O(V^V) //exponential
        if(src == dest) {
            System.out.println(path+dest+" ");
            return;
        }

        for(int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            printAllPath(graph, e.dest, dest, path+src+" ");
        }
    }
    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[6];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3, 1));

        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 1, 1));

        graph[4].add(new Edge(3, 0, 1));
        graph[4].add(new Edge(3, 1, 1));
    
        graph[5].add(new Edge(3, 0, 1));
        graph[5].add(new Edge(3, 2, 1));
        
        printAllPath(graph, 5, 1, "");
    }
}
