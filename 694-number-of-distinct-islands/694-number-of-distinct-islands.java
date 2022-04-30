class Solution {
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, sb, i, j, -1);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
    
    //dir:1 2 3 4 for 4 direction
    private void dfs(int[][] grid, StringBuilder sb, int i, int j, int dir) {
        int m = grid.length;
        int n = grid[0].length;
        //if we have visited one position, mark it as 0
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        sb.append(dir);
        dfs(grid, sb, i - 1, j, 1);
        dfs(grid, sb, i + 1, j, 2);
        dfs(grid, sb, i, j - 1, 3);
        dfs(grid, sb, i, j + 1, 4);
        sb.append(-dir);
    }
}