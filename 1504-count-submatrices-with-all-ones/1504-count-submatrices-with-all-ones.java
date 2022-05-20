class Solution {
    /*
    Even the brute force solution with O(m^2 x n^2) takes some work. This solution passes all the tests and its a good place to start
At every position within the matrix, we count all of the submatrices that have a top-left corner at that position.
I use the bound to "shrink" the search space because once we hit a zero, there is no point in iterating past that point.
    */
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += helper(mat, i, j);
            }
        }
        return res;
    }
    
    // count all submatrices with top-left corner at mat[a][b]
    private int helper(int[][] mat, int a, int b) {
        int m = mat.length;
        int n = mat[0].length;
        int res = 0;
        int col_bound = n;
        for (int i = a; i < m; i++) {
            for (int j = b; j < col_bound; j++) {
                if (mat[i][j] == 1) {
                    res += 1;
                } else {
                    col_bound = j;
                }
            }
        }
        return res;
    }
}