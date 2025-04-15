import java.util.*;

public class GoodQuestions {

    // https://leetcode.com/problems/validate-binary-tree-nodes/
    // mix of both trees and graph
    boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] indegree = new int[n]; // for finding incoming vertex

        for (int i =0 ; i < n ;i++){
            if (leftChild[i] != -1){
                indegree[leftChild[i]]++;
                 
                if (indegree[leftChild[i]] > 1){
                    return false;
                } 
            }

            if (rightChild[i] != -1){
                indegree[rightChild[i]]++;
                 
                if (indegree[rightChild[i]] > 1){
                    return false;
                } 
            }
        }

        int root = -1;
        int rootCount = 0;
        for (int i = 0; i < n; i++){
            if (indegree[i] == 0){
                root = i; // finding root
                rootCount++;
            }
        }
        if (rootCount > 1) return false; // can't be two roots

        boolean[] vis = new boolean[n];
        dfs(root, leftChild, rightChild, vis);

        for (boolean v : vis){
            if(!v) return false;
        }


        return true;
    }

    void dfs(int node, int[] l, int[] r, boolean[] vis){
        if (node == -1 || vis[node]) return;

        vis[node] = true;
        dfs(l[node], l, r, vis);
        dfs(r[node], l, r, vis);
    }


    // https://leetcode.com/problems/number-of-operations-to-make-network-connected/
    // using DFS
    int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1){
            return -1;
        }

        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int[] c : connections){
            graph[c[0]].add(c[1]);
            graph[c[1]].add(c[0]);
        }

        boolean[] vis = new boolean[n];
        int nC = 0; // no of components
        for(int i = 0; i < n; i++){
            nC += dfs(i, graph, vis);
        }

        return nC - 1;
    }

    int dfs(int node, List<Integer>[] graph, boolean[] vis){
        if(vis[node]){
            return 0;
        }
        vis[node] = true;

        for (int v : graph[node]){
            dfs(v, graph, vis);
        }
        return 1;
    }

    // using Disjoint Set
    int makeConnected2(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int cntExtras = 0;
        int m = connections.length;
        for (int i = 0; i < m ;i++){
            int u = connections[i][0];
            int v = connections[i][1];
            if (ds.findUPar(u) == ds.findUPar(v)){
                cntExtras++;
            } else {
                ds.unionBySize(u,v);
            }
        }

        int cntC = 0; 
        for (int i =0; i < n; i++){
            if(ds.parent.get(i) == i) {
                cntC++;
            }
        }

        int ans = cntC - 1; 
        if (cntExtras >= ans ){
            return ans;
        }

        return -1;
    }


    // https://leetcode.com/problems/accounts-merge/
    List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> mapMailNode = new HashMap<>();

        for (int i = 0; i < n ; i++){
            for (int j = 1; j < accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if(mapMailNode.containsKey(mail) == false){
                    mapMailNode.put(mail, i); 
                } else {
                    ds.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }

        ArrayList<String>[] mergeMail = new ArrayList[n];

        for (int i = 0; i < n; i++){
            mergeMail[i] = new ArrayList<String>();
        }

        for (Map.Entry<String, Integer> it : mapMailNode.entrySet()){
            String mail = it.getKey();
            int node = ds.findUPar(it.getValue());
            mergeMail[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++){
            if(mergeMail[i].size() == 0) continue;
            Collections.sort(mergeMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for (String it : mergeMail[i]){
                temp.add(it);
            }
            ans.add(temp);
        }

        return ans;
    }

    // https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
    int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        int n = stones.length;
        for (int i = 0; i < n; i++){
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1); // + 1 for safety reason
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
            map.put(nodeRow, 1);
            map.put(nodeCol, 1);
        }

        int cnt = 0;
        for(Map.Entry<Integer, Integer> it : map.entrySet()){
            if (ds.findUPar(it.getKey()) == it.getKey()){
                cnt++;
            }
        }
        return n - cnt;
    }


    // https://leetcode.com/problems/making-a-large-island/
    int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        
        int directions[][] = {{-1,0}, {0,-1}, {1,0}, {0,1}};

        // connecting 1's island
        for (int row = 0 ; row < n; row++){
            for (int col = 0; col < n; col++){
                if (grid[row][col] == 0){
                    continue;
                }
                for (int dir = 0; dir < 4; dir++){
                    int nRow = row + directions[dir][0];
                    int nCol = col + directions[dir][1];
                    if (isValid(nRow, nCol, n) && grid[nRow][nCol] == 1){
                        int nodeNo = row*n + col;
                        int adjNodeNo = nRow*n + nCol;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }

        // go across zero and try to convert 0 into 1;
        int mx = 0;
        for (int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if (grid[row][col] == 1){
                    continue;
                }

                HashSet<Integer> components = new HashSet<>();
                for (int i = 0; i < 4; i++){
                    int nRow = row + directions[i][0];
                    int nCol = col + directions[i][1];
                    if (isValid(nRow, nCol, n) && grid[nRow][nCol] == 1){
                        components.add(ds.findUPar(nRow * n + nCol));
                    }
                }

                int sizeTotal = 0;
                for (Integer parents: components){
                    sizeTotal += ds.size.get(parents);
                }
                mx = Math.max(mx, sizeTotal + 1);
            }
        }

        for (int cellNo = 0 ; cellNo < n*n ; cellNo++){
            mx = Math.max(mx, ds.size.get(ds.findUPar(cellNo)));
        }

        return mx;
    }
    boolean isValid(int row, int col, int n){
        return row >= 0 && col >= 0 && row < n && col < n;
    }
}
