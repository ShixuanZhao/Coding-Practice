class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n + 1);
        for (int[] e : edges) {
            int from = e[0];
            int to = e[1];
            if (dsu.find(from) == dsu.find(to)) {
                return e;
            }
            dsu.union(from, to);
        }
        return null;
    }
    
    class DSU {
        int[] parent;
        public DSU(int n) {
            parent = new int[n];
            for (int i = 1; i < n; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }
}