import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightWithK {

class Pair{
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    class Tuple{
        int stop, node, cost;

        public Tuple(int stop, int node, int cost){
            this.stop = stop;
            this.node = node;
            this.cost = cost;
        }
    }

    public int findCheapestPrice(int n, int[][] f, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        } 

        int m = f.length;
        for(int i = 0; i < m; i++){
            adj.get(f[i][0]).add(new Pair(f[i][1], f[i][2]));
        }

        Queue<Tuple> q = new LinkedList<>();
        int[] dist = new int[n];
        for(int i = 0; i < n; i++){
            dist[i] = (int)Integer.MAX_VALUE;
        }
        q.offer(new Tuple(0 ,src, 0));
        dist[src] = 0;

        while(!q.isEmpty()){
            Tuple curr = q.poll();
            int stop = curr.stop;
            int node = curr.node;
            int cost = curr.cost;

            for (Pair it : adj.get(node)){
                int adjNode = it.first;
                int edgeW = it.second;

                if (stop > k) continue;
                if (cost + edgeW < dist[adjNode] && stop <= k){
                    dist[adjNode] = cost + edgeW;
                    q.add(new Tuple(stop + 1, adjNode, cost + edgeW));
                }
            }
        }

        if (dist[dst] == Integer.MAX_VALUE){
            return -1;
        }

        return dist[dst];
    }

}
