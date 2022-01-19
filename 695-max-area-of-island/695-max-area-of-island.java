class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] direction = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int[] area = new int[1];
                    dfs(grid, direction, area, i, j);
                    res = Math.max(res, area[0]);
                }
            }
        }
        return res;
    }
    
   private void dfs(int[][] grid, int[][] direction, int[] area, int i, int j) {
       if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
       area[0]++;
       grid[i][j] = 0;
       for (int dir[] : direction) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            dfs(grid, direction, area, nextI, nextJ);
        }
   }
}

//方法2：dfs函数设置返回值，记录每次淹没的陆地的个数
// int maxAreaOfIsland(int[][] grid) {
//     // 记录岛屿的最大面积
//     int res = 0;
//     int m = grid.length, n = grid[0].length;
//     for (int i = 0; i < m; i++) {
//         for (int j = 0; j < n; j++) {
//             if (grid[i][j] == 1) {
//                 // 淹没岛屿，并更新最大岛屿面积
//                 res = Math.max(res, dfs(grid, i, j));
//             }
//         }
//     }
//     return res;
// }

// // 淹没与 (i, j) 相邻的陆地，并返回淹没的陆地面积
// int dfs(int[][] grid, int i, int j) {
//     int m = grid.length, n = grid[0].length;
//     if (i < 0 || j < 0 || i >= m || j >= n) {
//         // 超出索引边界
//         return 0;
//     }
//     if (grid[i][j] == 0) {
//         // 已经是海水了
//         return 0;
//     }
//     // 将 (i, j) 变成海水
//     grid[i][j] = 0;

//     return dfs(grid, i + 1, j)
//          + dfs(grid, i, j + 1)
//          + dfs(grid, i - 1, j)
//          + dfs(grid, i, j - 1) + 1;
// }