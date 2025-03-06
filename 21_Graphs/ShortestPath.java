import java.util.*;
class ShortestPath {

    // https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-undirected-graph-having-unit-distance
    int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        int[] dist = new int[adj.size()];
        for (int i = 0; i < dist.length; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        while(!q.isEmpty()){
            int node = q.poll();
            for (int it : adj.get(node)){
                if (dist[node] + 1 < dist[it]){
                    dist[it] = 1 + dist[node];
                    q.add(it);
                }
            }
        }
        
        for (int i = 0 ; i< dist.length ; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }
        return dist;
    }
}