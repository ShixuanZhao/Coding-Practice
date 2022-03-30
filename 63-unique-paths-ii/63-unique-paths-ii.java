class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        //M[i][j]:how many ways from (0, 0) to (i, j)
        int[][] M = new int[m][n];
        for (int i = 0; i < n && obstacleGrid[0][i] != 1; i++) {
            M[0][i] = 1;
        }
        for (int i = 0; i < m && obstacleGrid[i][0] != 1; i++) {
            M[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    M[i][j] = M[i][j - 1] + M[i - 1][j];
                }
            }
        }
        return M[m - 1][n - 1];
    }
}