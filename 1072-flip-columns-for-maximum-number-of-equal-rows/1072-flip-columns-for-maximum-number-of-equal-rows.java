class Solution {
    /*
    Assume the i-th row is an all-0s row after flipping x columns.

If there are any other all-0s row, say j-th row, then the j-th row before flipping should be the same as the i-th row.
If there are any other all-1s row, say k-th row, then the k-th row before flipping should be totally different from the i-th row.
For example:

 [1,0,0,1,0]                                                       [0,0,0,0,0]  // all-0s
 [1,0,0,1,0]  after flipping every cell in 0-th and 3-th columns   [0,0,0,0,0]  // all-0s
 [1,0,1,1,1] ----------------------------------------------------> [0,0,1,0,1]
 [0,1,1,0,1]                                                       [1,1,1,1,1]  // all-1s
 [1,0,0,1,1]                                                       [0,0,0,0,1]
 
 1st, 2nd, and 4th rows have all values equal.
After flipping, the 1st and 2nd rows are all-0s, and the 4th row are all-1s. We can find that before flipping:
the 2nd row is the same as the 1st row.
the 4th row is totally different from the 1st row.

So, the problem is transformed to: Find the i-th row, which has the most same or totaly different rows in the matrix.
    */
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            int[] flip = new int[n];
            for (int j = 0; j < n; j++) {
                flip[j] = 1 - matrix[i][j];
            }
            int cnt = 0;
            for (int k = i; k < m; k++) {
                if (Arrays.equals(matrix[k], matrix[i]) || Arrays.equals(matrix[k], flip)) {
                    cnt++;
                }
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}