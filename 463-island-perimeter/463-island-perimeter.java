class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j, visited, m, n);
                }
            }
        }
        return -1;
    }
    
    private int dfs(int[][] grid, int i, int j, boolean[][] visited, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 1;
        }
        //this is important to avoid duplicate border
        if (visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return dfs(grid, i - 1, j, visited, m, n) + dfs(grid, i + 1, j, visited, m, n) +
            dfs(grid, i, j - 1, visited, m, n) + dfs(grid, i, j + 1, visited, m, n);
    }
}