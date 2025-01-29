import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Questions {

            
    class Pair {
        int first;
        int second;
    
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }


    // converting matric into a adjacentList
    ArrayList<ArrayList<Integer>> convert(int[][] grid){
        int V = grid.length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (grid[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        return adjList;
    }


    // 547 : 
    int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;

        for (int i = 0; i < isConnected.length; i++){
            if(!visited[i]){
                count++;
                dfs(isConnected, visited, i);
            }
        }
        return count;
    }
    void dfs(int[][] isConnected, boolean[] visited, int i){
        visited[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j);
            }
        }
    }
    // geeks for geeks same ques: this solution can be solve for leetcode, 
    // but on leetcode try solving with matrix
    int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int[] visited = new int[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                count++;
                dfs(i, adjList, visited);
            }
        }
        return count;
    }

    void dfs(int node, ArrayList<ArrayList<Integer>> adjList, int[] visited){
         // updating to make sure all visited in a graph component
         // and can start with a new start when call comes out in 
         // numProvince function
        visited[node] = 1;
        for (Integer n :  adjList.get(node)){
            if (visited[n] == 0) {
                dfs(n, adjList, visited);
            }
        }
    }


    // 200 :
    int numIslands(char[][] grid) {
        int island = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (vis[r][c] == 0 && grid[r][c] == '1') {
                    island++;
                    bfs(r, c, vis, grid);
                }
            }            
        }
        return island;
    }

    void bfs(int r, int c, int[][] vis, char[][] grid) {
        vis[r][c] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(r, c));
        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            // 4 directions: up, down, left, right
            int[] delrow = {-1, 0, 1, 0};
            int[] delcol = {0, 1, 0, -1};

            // Traverse neighbors in 4 directions
            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                }
            } 

            // // Pairs of row and column offsets for 4 directions
            // int[][] directions = {
            //     {-1, 0}, // up
            //     {0, 1},  // right
            //     {1, 0},  // down
            //     {0, -1}  // left
            // };
            // for (int[] dir : directions) {
            //     int nrow = row + dir[0];
            //     int ncol = col + dir[1];

            //     // Check if neighbor is within bounds and not visited
            //     if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
            //         vis[nrow][ncol] = 1;
            //         q.add(new Pair(nrow, ncol));
            //     }
            // }
        }
    }
    // this covers all the 8 directions diagonally
    //  but on leetcode it requires only 4 directstions therefore above bfs will be used
    void bfs2(int r, int c, int[][] vis, char[][] grid) {
        vis[r][c] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(r, c));
        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            // traverse in neighbour and mark them 
            for (int delrow = -1; delrow <= 1; delrow++){
                for (int delcol = -1; delcol <= 1; delcol++){
                    int nrow = row + delrow; // neighbour row
                    int ncol = col + delcol; // neighbour col
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                        vis[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }


    // 733 : Flood Fill Algo
    int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = image;
        int initialCol = image[sr][sc];
        dfs(sr, sc, ans, image, color, initialCol);
        return ans;
    }

    void dfs(int row, int col, int[][] ans, int[][] image, int newColor, int initialCol){
        ans[row][col] = newColor;
        int[][] directions = {
            {-1, 0}, // up
            {0, 1},  // right
            {1, 0},  // down
            {0, -1}  // left
        };
        for (int[] dir : directions) {
            int nrow = row + dir[0];
            int ncol = col + dir[1];
            if (nrow >= 0 && nrow < image.length && ncol >= 0 && ncol < image[0].length && image[nrow][ncol] == initialCol && ans[nrow][ncol] != newColor) {
                dfs(nrow, ncol, ans, image, newColor, initialCol);
            }
        }
    }

    // 542 :
    class Node {
        int first;
        int second;
        int third;

        public Node(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    public int[][] updateMatrix(int[][] grid) {
        int n = grid.length; 
	    int m = grid[0].length; 
	    int vis[][] = new int[n][m]; 
	    int dist[][] = new int[n][m]; 

	    // <coordinates, steps>
	    Queue<Node> q = new LinkedList<>();
	    for(int i = 0;i<n;i++) {
	        for(int j = 0;j<m;j++) {
	            if(grid[i][j] == 0) {
	                q.add(new Node(i, j, 0)); 
	                vis[i][j] = 1; 
	            }
	            else { 
	                vis[i][j] = 0; 
	            }
	        }
	    }
	    
	    int delrow[] = {-1, 0, +1, 0}; 
	    int delcol[] = {0, +1, 0, -1}; 
        
	    while(!q.isEmpty()) {
	        int row = q.peek().first; 
	        int col = q.peek().second; 
	        int steps = q.peek().third; 
	        q.remove(); 
	        dist[row][col] = steps; 
	        
	        for(int i = 0; i < 4; i++) {
	            int nrow = row + delrow[i]; 
	            int ncol = col + delcol[i]; 
	    
	            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0)  {
	                vis[nrow][ncol] = 1; 
    	            q.add(new Node(nrow, ncol, steps+1));  
	            } 
	            }
	        }
	    return dist; 
    }

    // Surrounded Regions: 130 : Similar solution for 1020 too just replace '0' to 1 and add count and return it
    void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        
        for (int col = 0; col < m; col++){
            // first row 
            if (vis[0][col] == false && board[0][col] == 'O'){
                dfs(0, col, board, vis, n, m);
            }    

            // last row 
            if(vis[n - 1][col] == false && board[n - 1][col] == 'O'){
                dfs(n - 1, col, board, vis, n ,m);
            }
        }

        for (int row = 0; row < n; row++){
            // first col 
            if (vis[row][0] == false && board[row][0] == 'O'){
                dfs(row, 0, board, vis, n ,m);
            }

            // last col
            if (vis[row][m - 1] == false && board[row][m - 1] == 'O'){
                dfs(row, m - 1, board, vis, n, m);
            }   
        }

        for (int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                if(vis[r][c] == false && board[r][c] == 'O'){
                    board[r][c] = 'X';
                }
            }
        }        
    }

    void dfs(int row, int col, char[][] board, boolean[][] vis, int n, int m){
        vis[row][col] = true;
        int[] dirRow = {-1, 0, +1, 0};
        int[] dirCol = {0, -1, 0, +1};

        for (int i = 0; i < 4; i++){
            int nRow = row + dirRow[i];
            int nCol = col + dirCol[i];

            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !vis[nRow][nCol] && board[nRow][nCol] == 'O'){
                dfs(nRow, nCol, board, vis, n ,m);
            } 
        }
    }


    // 1020 : Number of Enclave using Multi Source BFS:
    
    
}
