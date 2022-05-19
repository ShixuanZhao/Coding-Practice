class Solution {
    /*
    For brute force solution, for each C[ i ] [ j ], it uses C[ i ] [ j ] += A[ i ] [ k ] * B[ k ] [ j ] where k = [ 0, n].Note: even A[ i ] [ k ] or B[ k ] [ j ] is 0, the multiplication is still executed.

For the above smart solution, if A[ i ] [ k ] == 0 or B[ k ] [ j ] == 0, it just skip the multiplication . This is achieved by moving for-loop" for ( k = 0; k < n; k++ ) " from inner-most loop to middle loop, so that we can use if-statement to tell whether A[ i ] [ k ] == 0 or B[ k ] [ j ] == 0. This is really smart.
    */
    //brute force
    // public int[][] multiply(int[][] mat1, int[][] mat2) {
    //     int m = mat1.length;
    //     int k = mat1[0].length;
    //     int n = mat2[0].length;
    //     int[][] res = new int[m][n];
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             for (int temp = 0; temp < k; temp++) {
    //                 res[i][j] += mat1[i][temp] * mat2[temp][j];
    //             }
    //         }
    //     }
    //     return res;
    // }
    //smarter
     public int[][] multiply(int[][] mat1, int[][] mat2) {
         int m = mat1.length;
         int k = mat1[0].length;
         int n = mat2[0].length;
         int[][] res = new int[m][n];
         for (int i = 0; i < m; i++) {
             for (int k1 = 0; k1 < k; k1++) {
                 if (mat1[i][k1] != 0) {
                     for (int j = 0; j < n; j++) {
                         if (mat2[k1][j] != 0) {
                             res[i][j] += mat1[i][k1] * mat2[k1][j];
                         }
                     }
                 }
             }
         }
         return res;
     }
}