import java.util.*;


public class DijkstraAlgo {

    class iPair {
        int first, second;
    
        iPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        // Write your code here
        
        // min heap
        PriorityQueue<iPair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.first));
        int[] dist = new int[adj.size()];
        
        for (int i = 0; i < dist.length; i++){
            dist[i] = (int)(1e9);
        }
        
        dist[src] = 0;
        pq.add(new iPair(0, src));
        
        while (!pq.isEmpty()){
            iPair curr = pq.poll();
            int dis = curr.first;
            int node = curr.second;
            
            if (dis > dist[node]) {
                continue;
            }
            
            for (iPair it : adj.get(node)) {
                int adjNode = it.first;
                int edgeWeight = it.second;
                
                if (adjNode >= 0 && adjNode < dist.length && dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dist[node] + edgeWeight;
                    pq.add(new iPair(dist[adjNode], adjNode));
                }
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for (int d : dist) {
            res.add(d);
        }
        return res;
    }

}
