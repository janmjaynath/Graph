import java.util.*;
public class PrimAlgorithms {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s,int d,int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

    }
    static void creategraph(ArrayList<Edge> []graph){

        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1,10));
        graph[0].add(new Edge(0, 2,15));
        graph[0].add(new Edge(0, 3,30));


        graph[1].add(new Edge(1,0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2,0, 15));
        graph[2].add(new Edge(2, 3,50));


        graph[3].add(new Edge(3,1, 40));
        graph[3].add(new Edge(3,2, 50));

       
    }

    static class pair implements Comparable<pair>{
        int v;
        int cost;

        public pair(int v,int c){
            this.v = v;
            this.cost = c;
        }

        @Override
        public int compareTo(pair p2){
            return this.cost - p2.cost;
        }
    }

    public static void MST(ArrayList<Edge> graph[]){
        boolean visit[] = new boolean[graph.length];
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(0,0));
        int countcost = 0;

        while (! pq.isEmpty()) {
            pair curr = pq.remove();
            if(!visit[curr.v]){
                visit[curr.v] = true;
                countcost += curr.cost;

                for(int i=0;i<graph[curr.v].size();i++){
                    Edge e = graph[curr.v].get(i);
                    pq.add(new pair(e.dest,e.wt));
                }
            }
            
        }
        System.out.println("final(min) cost of MST:" + countcost);
    }

    public static void main(String[] args) {
        int v = 4;
    ArrayList<Edge>[] graph = new ArrayList[v];

    creategraph(graph);

        MST(graph);
    }

}
