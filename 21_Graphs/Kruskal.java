import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int _src, int _dest, int _weight) {
            this.src = _src;
            this.dest = _dest;
            this.weight = _weight;
        }

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    static class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                rank.add(0);
                parent.add(i);
                size.add(1);
            }
        }

        public int findUPar(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        public void unionBySize(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v)
                return;
            if (size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
            } else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }

    class Solution {
        static int spanningTree(int V, int E, List<List<int[]>> adj) {
            // Code Here.
            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                for (int[] edge : adj.get(i)) {
                    int adjNode = edge[0];
                    int wt = edge[1];
                    // Add the edge in both directions (since the graph is undirected)
                    if (i < adjNode) {
                        edges.add(new Edge(i, adjNode, wt));
                    }
                }
            }

            DisjointSet ds = new DisjointSet(V);
            Collections.sort(edges);
            int mstWt = 0;

            for (int i = 0; i < edges.size(); i++) {
                int wt = edges.get(i).weight;
                int u = edges.get(i).src;
                int v = edges.get(i).dest;

                if (ds.findUPar(u) != ds.findUPar(v)) {
                    mstWt += wt;
                    ds.unionBySize(u, v);
                }
            }
            return mstWt;
        }
    }

}
