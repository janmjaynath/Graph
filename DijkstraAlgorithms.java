import java.util.*;
public class DijkstraAlgorithms {
    
    static class Edge {
        int src;
        int dest;
        int weight;
        
        public Edge(int s,int d,int w){
            this.src = s;
            this.dest = d;
            this.weight=w;
        }
    }
     static void creategraph(ArrayList<Edge> []graph){

        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1,2));
        graph[0].add(new Edge(0, 2,4));

        graph[1].add(new Edge(1,3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2,4, 3));

        graph[3].add(new Edge(3,5, 1));

        graph[4].add(new Edge(4,3, 2));
        graph[4].add(new Edge(4,5, 5));
    }

    static class pair implements Comparable<pair>{
        int n;
        int path;

        public pair(int n,int p){
            this.n = n;
            this.path = p;
        }

        @Override
        public int compareTo(pair p2){
            return this.path - p2.path;
    }

    public static void dijkstra(ArrayList<Edge> graph[],int src){
        int dist[] = new int[graph.length];

        for(int i=0;i<graph.length;i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean visit[] = new boolean[graph.length];
        PriorityQueue<pair> pq = new PriorityQueue<>();

        pq.add(new pair(src,0 ));

        while (!pq.isEmpty()){
            pair curr = pq.remove();
            if(!visit[curr.n]){
                visit[curr.n] = true;

                for(int i=0;i<graph[curr.n].size();i++){
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v  = e.dest;
                    int w = e.weight;

                    if(dist[u]+w < dist[v]){
                        dist[v] = dist[u] + w;
                        pq.add(new pair(v, dist[v]));
                    }
                }

            }
        }

        for(int i=0;i<dist.length;i++){
            System.out.println(dist[i] + " ");
        }
        System.out.println();

        
}

    public static void main(String[] args) {
        int v = 6;
    ArrayList<Edge>[] graph = new ArrayList[v];

    creategraph(graph);
        int src = 0;
       dijkstra(graph,src);

    }
    }
}
