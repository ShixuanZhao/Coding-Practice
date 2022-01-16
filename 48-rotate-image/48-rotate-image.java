class Solution {
    /*
    for level
        for each the ele in a certain edge
            upper
            right
            down
            left
            
            
    */
    public void rotate(int[][] matrix) {
        //推导：new -> old  {I = n - 1 - j    J = i} 
        int n = matrix.length;
        if (n <= 1) {
            return;
        }
        for (int level = 0; level < n / 2; level++) {
            int left = level;
            int right = n - 2 - level;
            for (int i = left; i <= right; i++) {
                int temp = matrix[left][i];
                matrix[left][i] = matrix[n - 1 - i][left];
                matrix[n - 1 - i][left] = matrix[n - 1 - left][n - 1 - i];
                matrix[n - 1 - left][n - 1 - i] = matrix[i][n - 1 - left];
                matrix[i][n - 1 - left] = temp;
            }
        }
    }
    /*
 * clockwise rotate
 * first reverse up to down, then swap the symmetry 
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
*/
    // public void rotate(int[][] matrix) {
    //     int start = 0;
    //     int end = matrix.length - 1;
    //     while (start < end) {
    //         int[] temp = matrix[start];
    //         matrix[start] = matrix[end];
    //         matrix[end] = temp;
    //         start++;
    //         end--;
    //     }
    //     for (int i = 0; i < matrix.length; i++) {
    //         for (int j = i + 1; j < matrix[0].length; j++) {
    //             int temp = matrix[i][j];
    //             matrix[i][j] = matrix[j][i];
    //             matrix[j][i] = temp;
    //         }
    //     }
    // }
    /*
 * anticlockwise rotate
 * first reverse left to right, then swap the symmetry
 * 1 2 3     3 2 1     3 6 9
 * 4 5 6  => 6 5 4  => 2 5 8
 * 7 8 9     9 8 7     1 4 7
*/
}