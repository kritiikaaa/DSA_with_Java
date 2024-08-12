package Graphs;
import java.util.*;
public class BFSutil {

    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        // 0-vertex
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        // 1-vertex
        graph[1].add(new Edge(1,0,1));

        // 2-vertex
        graph[2].add(new Edge(2,0,1));

        // 3-vertex
        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        //4-vertex
        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        //5-vertex
        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        // 6-vertex
        graph[6].add(new Edge(6,5,1));
    }

    public static void bfs(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                bfsUtil(graph, visited, i);
            }
        }
    }
    public static void bfsUtil(ArrayList<Edge> graph[], boolean[] visited, int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start); //source

        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visited[curr]){
                System.out.print(curr+" ");
                visited[curr] = true;
                for(int i=0; i<graph[curr].size(); i++){
                    q.add(graph[curr].get(i).dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        bfs(graph);
    }
}
