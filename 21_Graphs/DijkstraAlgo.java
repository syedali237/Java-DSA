import java.util.*;


public class DijkstraAlgo {

    class iPair {
        int first, second;
    
        iPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    class Pair {
        int first, second;
    
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        // Write your code here
        
        // min heap
        PriorityQueue<iPair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.first));
        int[] dist = new int[adj.size()];
        
        for (int i = 0; i < dist.length; i++){
            dist[i] = (int)(1e9);
        }
        
        dist[src] = 0;
        pq.add(new iPair(0, src));
        
        while (!pq.isEmpty()){
            iPair curr = pq.poll();
            int dis = curr.first;
            int node = curr.second;
            
            if (dis > dist[node]) {
                continue;
            }
            
            for (iPair it : adj.get(node)) {
                int adjNode = it.first;
                int edgeWeight = it.second;
                
                if (adjNode >= 0 && adjNode < dist.length && dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dist[node] + edgeWeight;
                    pq.add(new iPair(dist[adjNode], adjNode));
                }
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for (int d : dist) {
            res.add(d);
        }
        return res;
    }


    class Tuple {
        int diff, row, col;

        public Tuple(int diff, int row, int col) {
            this.diff = diff;
            this.row = row;
            this.col = col;
        }
    }
    // https://leetcode.com/problems/path-with-minimum-effort/
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dist[i][j] = (int)Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;

        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x,y) -> x.diff - y.diff);
        pq.add(new Tuple(0,0,0));
        int[][] dir = {
            {-1,0}, {0,1}, {1,0}, {0,-1}
        };

        while(!pq.isEmpty()){
            Tuple curr = pq.poll();
            int diff = curr.diff;
            int r = curr.row;
            int c = curr.col;

            if (r == n - 1 && c == m - 1){
                return diff;
            }

            for (int[] d : dir){
                int nRow = r + d[0];
                int nCol = c + d[1];

                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m){
                    int nEffort = Math.max(Math.abs(heights[r][c] - heights[nRow][nCol]), diff);

                    if (nEffort < dist[nRow][nCol]){
                        dist[nRow][nCol] = nEffort;
                        pq.add(new Tuple(nEffort, nRow, nCol));
                    }
                }
            } 
        }

        return 0;
    }

    // https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-multiplications-to-reach-end

    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        
        if (start == end) return 0;
        
        Queue<Pair> q = new LinkedList<>();
        int[] dist = new int[100000];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        q.offer(new Pair(0, start));
        
        int mod = 100000;
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int steps = curr.first;
            int node = curr.second;
            
            for (int it : arr){
                int num = (it*node) % mod;
                
                if (steps + 1 < dist[num]){
                    dist[num] = steps + 1;
                    if (num == end){
                        return steps + 1;
                    }
                    q.add(new Pair(steps + 1, num));
                }
            }
        }
        
        return -1;
    }

}
