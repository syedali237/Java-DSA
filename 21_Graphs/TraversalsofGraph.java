
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TraversalsofGraph {

    List<Integer> bfs(int V, ArrayList<ArrayList<Integer>> adj){
        List< Integer> bfs = new ArrayList<>();
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        //0  based graph
        queue.offer(0);
        visited[0] = true;

        while(!queue.isEmpty()){
            Integer node = queue.poll();
            bfs.add(node);

            for (Integer n : adj.get(node)){
                if (visited[n] == false) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

        return bfs;
    }

    List<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        boolean visted[] = new boolean[adj.size()];
        visted[0] = true;
        ArrayList<Integer> list =  new ArrayList<>();
        dfs(0, visted, adj, list);
        return list;
    }

    void dfs(int node, boolean visited[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls){

        visited[node] = true;
        ls.add(node);

        for(Integer n : adj.get(node)){
            if (!visited[n]) {
                dfs(n, visited, adj, ls);
            }
        }
    }

}
