class Solution {
    /*
    M[i][j]: ways from (0, 0) to (i, j)
    M[i][j] = M[i - 1][j] + M[i][j - 1]
    */
    public int uniquePaths(int m, int n) {
        int[][] M = new int[m][n];
        for (int i = 0; i < m; i++) {
            M[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            M[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                M[i][j] = M[i - 1][j] + M[i][j - 1];
            }
        }
        return M[m - 1][n - 1];
    }
}