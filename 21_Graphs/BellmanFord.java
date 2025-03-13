import java.util.Arrays;

public class BellmanFord {

static int[] bellmanFord(int V, int[][] edges, int src) {
        // Write your code here
        int[] dist = new int[V];
        Arrays.fill(dist, (int)(1e8));
        dist[src] = 0;
        // V x E
        for(int i = 0; i < V - 1; i++){
            for(int[] it : edges){
                int u = it[0];
                int v = it[1];
                int w = it[2];
                
                if (dist[u] != 1e8 && dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                }
            }
        }
        
        // Nth relaxation for checking negative cycle
        for (int[] it : edges){
            int u = it[0];
            int v = it[1];
            int w = it[2];
            if (dist[u] != 1e8 && dist[u] + w < dist[v]){
                return new int[] {-1};
            }
        }
        
        return dist;
    }

}
