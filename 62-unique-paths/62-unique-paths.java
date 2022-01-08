class Solution {
    /*
        //dp
        M[i][j]:the number of paths to get the position (i, j) from start position
        M[i][j] = M[i][j - 1] + M[i - 1][j]
        1 1
        1 2
    */
    public int uniquePaths(int m, int n) {
        int[][] M = new int[m][n];
        M[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j - 1 >= 0) {
                    M[i][j] = M[i][j - 1];
                }
                if (i - 1 >= 0) {
                    M[i][j] += M[i - 1][j];
                }
            }
        }
        return M[m - 1][n - 1];
    }
}