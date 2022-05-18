class Solution {
    /*
    adjancency matrix
    isConnected = [[1,1,0],[1,1,0],[0,0,1]]
    110
    110
    001
    第一行：1和1连着，1和2连着，1和3不连
    第二行：2和1连着，2和2连着，2和3不连
    */
//     public int findCircleNum(int[][] isConnected) {
//         //number of city
//         int n = isConnected.length;
//         boolean[] visited = new boolean[n];
//         int res = 0;
//         for (int i = 0; i < n; i++) {
//             if (!visited[i]) {
//                 res++;
//                 dfs(isConnected, visited, i);
//             }
//         }
//         return res;
//     }
    
//     //mark all connected city as visited
//     //i is the start city
//     private void dfs(int[][] isConnected, boolean[] visited, int i) {
//         visited[i] = true;
//         //all other city
//         for (int j = 0; j < isConnected.length; j++) {
//             if (!visited[j] && isConnected[i][j] == 1) {
//                 dfs(isConnected, visited, j);
//             }
//         }
//     }
    
    //DSU
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int res = 0;
        DSU dsu = new DSU(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    dsu.union(i, j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            //find a root node
            if (i == dsu.find(i)) {
                res++;
            }
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