class Solution {
    int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        boolean[][] island = new boolean[m][n];
        int cnt = 0;
        DSU dsu = new DSU(m * n);
        for (int[] cur : positions) {
            if (island[cur[0]][cur[1]]) {
                //is already island, do not need to flip, just return
                res.add(cnt);
                continue;
            }
            cnt++;
            island[cur[0]][cur[1]] = true;
            //union neighboor is neighboor is island
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || !island[x][y]) {
                    continue;
                }
                //serialize to 1D, unique ID for find
                int component1 = dsu.find(cur[0] * n + cur[1]);
                int component2 = dsu.find(x * n +  y);
                if (component1 != component2) {
                    dsu.union(component1, component2);
                    cnt--;
                }
            }
            res.add(cnt);
        }
        return res;
    }
    
    class DSU {
        int[] parent;
        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
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