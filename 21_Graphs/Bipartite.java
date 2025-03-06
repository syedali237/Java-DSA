public class Bipartite {

    // 785
    boolean isBipartite(int[][] graph) {
        int[] col =  new int[graph.length];        

        for (int i = 0; i < col.length; i++) {
            col[i] = -1;
        }

        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {
                if(dfs(i, 0, col, graph) == false) return false; 
            }
        }

        return true;
    }

    boolean dfs(int node, int colour, int[] col, int[][] graph) {
        col[node] = colour;
        
        for (int it : graph[node]){
            if (col[it] == -1) {
                if (dfs(it, 1 - colour, col, graph) == false) return false;
            } else if (col[it] == colour) {
                return false;
            }
        }
        
        return true;
    }

}
