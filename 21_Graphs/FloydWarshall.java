public class FloydWarshall {

    // Multi source algo
    // https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1
    void shortestDistance(int[][] mat) {
        // Code here
        int n = mat.length;
        
        for (int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == -1){
                    mat[i][j] = (int)(1e9);
                }
            }
        }
        
        for (int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                }
            }
        }

        // for negative cycle
        // for (int i = 0; i < n; i++){
        //     if (mat[i][i] < 0) {
        //         return "negative cycle"
        //     }
        // }
        
        for (int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == (int)(1e9)){
                    mat[i][j] = -1;
                }
            }
        }
    }

}
