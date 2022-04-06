class Solution {
    /*
    First find out where the start and the end is.
Also We need to know the number of empty cells.

We we try to explore a cell,
it will change 0 to -2 and do a dfs in 4 direction.

Initially int empty = 1;, it represents the starting point.
 Because during backtracking, both grid[x][y] == 0 && grid[x][y] == 1 will be set to -2 
firstly and reset back to grid[x][y] = 0, i.e. grid[x][y] == 1 is also counted as 0 during DFS + Backtracking.
    */
    //empty = 1
    int res = 0, empty = 1, sx, sy, ex, ey;
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) empty++;
                else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
            }
        }
        dfs(grid, sx, sy);
        return res;
    }
    
    public void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < 0)
            return;
        if (grid[x][y] == 2) {
            if (empty == 0) res++;
            return;
        }
        //have visited
        grid[x][y] = -2;
        empty--;
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
        grid[x][y] = 0;
        empty++;
    }
}