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

    // https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/

    int findTheCity(int n, int[][] edges, int threshold) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        for(int i = 0; i <n ; i++) dist[i][i] = 0;

        for (int k = 0; k < n; k++){
            for (int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int cntMax = n + 1;
        int cityNo = -1;
        for (int city = 0; city < n; city++){
            int cnt = 0;
            for (int adjCity = 0; adjCity < n; adjCity++){
                if(dist[city][adjCity] <= threshold){
                    cnt++;
                }
            }

            if(cnt <= cntMax){
                cityNo = city;
                cntMax = cnt;
            }
        }

        return cityNo;
        
    }

}
