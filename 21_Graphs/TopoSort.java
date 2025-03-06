import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopoSort {

    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        boolean[] vis = new boolean[adj.size()];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0 ; i < vis.length; i++){
            if (!vis[i]) {
                dfs(i, vis, adj, stack);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        while (!stack.isEmpty()) {
            ans.add(stack.peek());
            stack.pop();
            i++;
        }
        return ans;
    }

    static void dfs(int node, boolean [] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        vis[node] = true;
        for (int i : adj.get(node)){
            if (!vis[i]) {
                dfs(i, vis, adj, st);
            }
        }
        st.push(node);
    }


    // using BFS : Kahns Algo
    static int[] topologicalSortBFS(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        int[] indegree = new int[adj.size()];
        for (int i = 0; i < indegree.length; i++) {
            for ( int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0){
                q.add(i);
            }
        }

        int[] ans = new int[adj.size()];
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            ans[i] = node;
            i++;
            q.remove();

            for (int it : adj.get(node)){
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return ans;
    }
}