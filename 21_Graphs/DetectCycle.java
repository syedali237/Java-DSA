
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycle {

    class Pair {
        int first;
        int second;
    
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    // using BFS
    boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[adj.size()];
        for (int i = 0; i < vis.length; i++) {
            if (vis[i] == false) {
                if (detect(i, adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean detect(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[src] = true;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src, -1));
        while(!q.isEmpty()){
            int node = q.peek().first;
            int parent = q.peek().second;
            q.poll();

            for (int adjNode : adj.get(node)){
                if(vis[adjNode] == false){
                    vis[adjNode] = true;
                    q.add(new Pair(adjNode, node));
                } else if (parent != adjNode) {
                    return true;
                }
            }
        }

        return false;
    }


    // using DFS:
    boolean isCycle2(ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[adj.size()];
        for (int i = 0; i < vis.length; i++) {
            if (vis[i] == false) {
                if (dfs(i, -1, adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[node] = true;
        for (int adjNodes : adj.get(node)){
            if (vis[adjNodes] == false) {
                if (dfs(adjNodes, node, adj, vis)) {
                    return true;
                }
            } else if (adjNodes != parent){
                return true;
            }
        }
 
        return false;
    }

}
