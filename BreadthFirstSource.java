import java.util.*;
public class BreadthFirstSource{
        static class Edge{
            int src;
            int dest;
            int weight;
    
            Edge(int s,int e,int w){
                this.src = s;
                this.dest = e;
                this.weight = w;
            }
        }
    
        public static void creategraph(  ArrayList<Edge> [] graph){
            for(int i=0;i<graph.length;i++){
                graph[i] = new ArrayList<>();
            }
            //0 - vertics
            graph[0].add(new Edge(0, 1, 5));
            graph[0].add(new Edge(0, 2, 1));
    
            //1-vertics
            graph[1].add(new Edge(1, 0, 1));
            graph[1].add(new Edge(1, 3, 1));
    
            //2-vertics
            graph[2].add(new Edge(2, 0, 1));
            graph[2].add(new Edge(2, 4, 1));
    
            //3-vertics
            graph[3].add(new Edge(3, 1, 1));
            graph[3].add(new Edge(3, 4, 1));
            graph[3].add(new Edge(3, 5, 1));
    
            //4-vertics
            graph[4].add(new Edge(4 ,2, 1));
            graph[4].add(new Edge(4 ,3, 1));
            graph[4].add(new Edge(4 ,5, 1));

            //5-vertics
            graph[5].add(new Edge(5 ,3, 1));
            graph[5].add(new Edge(5 ,4, 1));
            graph[5].add(new Edge(5 ,6, 1));
    
        }

        public static void BFS( ArrayList<Edge> [] graph){
            Queue<Integer> q = new LinkedList<>();
            boolean visit[] = new boolean[graph.length];
            q.add(0);

            while(!q.isEmpty()){
                int curr = q.remove();
                if(!visit[curr]){
                    System.out.println(curr+"");
                    visit[curr] = true;
                    for(int i=0;i<graph[curr].size();i++){
                        Edge e = graph[curr].get(i);
                        q.add(e.dest);
                    }
                }

            }
                    
        }
        
        public static void main(String[] args) {
          int v = 7;
          ArrayList<Edge>[] graph = new ArrayList[v];

          creategraph(graph);
          BFS(graph);
    
        }
    }

