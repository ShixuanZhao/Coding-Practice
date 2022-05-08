class Solution {
    //dfs O(m * n) boyh for dfs and bfs
    // public int numIslands(char[][] grid) {
    //     //dfs when we meet "1" we mark it as "0"
    //     //Also, we can use DFS iterative way which use extra space stack can work for big data
    //     /*
    //       ["0","0","0","0","0"],
    //       ["0","0","0","0","0"],
    //       ["0","0","0","0","0"], cnt == 1
    //       ["0","0","0","0","0"]
    //     */
    //     int[][] direction = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    //     int res = 0;
    //     int m = grid.length;
    //     int n = grid[0].length;
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (grid[i][j] == '1') {
    //                 res++;
    //                 dfs(i, j , grid, direction);
    //             }
    //         }
    //     }
    //     return res;
    // }
    
    //run dfs from (i, j), mark the cur position as "0" and continue to run dfs from its adjancenct position
    // private void dfs(int i, int j, char[][] grid, int[][] direction) {
    //     if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
    //         return;
    //     }
    //     grid[i][j] = '0';
    //     for (int dir[] : direction) {
    //         int nextI = i + dir[0];
    //         int nextJ = j + dir[1];
    //         dfs(nextI, nextJ, grid, direction);
    //     }
    // }
    
        public int numIslands(char[][] grid) {
         int[][] direction = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            int res = 0;
            int m = grid.length;
            int n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        res++;
                        bfs(i, j , grid, direction);
                    }
                }
            }
            return res;
       }
    
        private void bfs(int i, int j, char[][] grid, int[][] direction) {
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[] {i, j});
            grid[i][j] = '1';
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                for (int[] dir : direction) {
                    int nextI = x + dir[0];
                    int nextJ = y + dir[1];
                    //grid[nextI][nextJ] == '0' means we meet water or we have visited
                    if (nextI < 0 || nextI >= grid.length || nextJ < 0 || nextJ >= grid[0].length || grid[nextI][nextJ] == '0') {
                        continue;
                    }
                    //mark visited
                    grid[nextI][nextJ] = '0';
                    q.offer(new int[] {nextI, nextJ});
                }
            }
        }
}

 