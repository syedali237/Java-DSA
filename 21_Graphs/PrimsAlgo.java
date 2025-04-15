import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgo {
    static class Pair{
        int first, second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.first - y.first);
        
        int[] vis = new int[V];
        // wt, node
        pq.add(new Pair(0, 0)); // parent is not required since not getting the MST
        int sum = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int wt = curr.first;
            int node = curr.second;
            
            if (vis[node] == 1) continue;
            
            vis[node] = 1;
            sum += wt;
            
            for (int[] it : adj.get(node)){
                int edW = it[1];
                int adjNode = it[0];
                
                if(vis[adjNode] == 0){
                    pq.add(new Pair(edW, adjNode));
                }
            }
        }    
        return sum;
    }
}
