class Solution {
//     rangeSum[i + 1][j + 1] corresponds to cell (i, j);
// rangeSum[0][j] and rangeSum[i][0] are all dummy values, which are used for the convenience of computation of DP state transmission formula.
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m - 1, i + k);
                int c2 = Math.min(n - 1, j + k);
                // Since `sum` start with 1 so we need to increase r1, c1, r2, c2 by 1
                r1++; c1++; r2++; c2++;
                res[i][j] = sum[r2][c2] - sum[r2][c1 - 1] - sum[r1 - 1][c2] + sum[r1 - 1][c1 - 1];
            }
        }
        return res;
    }
}