class Solution {
    /*
        //dp
        M[i][j]:min path sum from start position to (i, j)
        0 1 2 
      0 1 4 5   M[i][j] = Math.min(M[i - 1][j], M[i][j - 1]) + grid[i][j]
      1 2 7 6 
      2 6 8 7
      
    */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] M = new int[m][n];
        M[0][0] = grid[0][0];
        //first col
        for (int i = 1; i < m; i++) {
            M[i][0] = grid[i][0] + M[i - 1][0]; 
        }
        //first row
        for (int j = 1; j < n; j++) {
            M[0][j] = grid[0][j] + M[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                M[i][j] = Math.min(M[i - 1][j], M[i][j - 1]) + grid[i][j];
            }
        }
        return M[m - 1][n - 1];
    }
}