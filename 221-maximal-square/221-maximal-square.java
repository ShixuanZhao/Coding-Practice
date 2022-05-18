class Solution {
    //// 伪代码
// if (matrix(i - 1, j - 1) == '1') {
//     dp(i, j) = min(dp(i - 1, j), dp(i, j - 1), dp(i - 1, j - 1)) + 1;
// }
    //以（i，j）为右下角的最大边长
    /*
    0 1 2 3 4 5 
  0 0 0 0 0 0 0
  1 0 1 0 1 0 0
  2 0 1 0 1 1 1
  3 0 1 1 1 2 2
  4 0
  
  
  dp[i][j] represents the length of the square which lower right corner is located at (i, j).
If the value of this cell is also 1, then the length of the square is the minimum of: the one above, its left, and diagonal up-left value +1. Because if one side is short or missing, it will not form a square.
    */
    public int maximalSquare(char[][] matrix) {
      //为了代码简洁，我们 假设补充 了多一行全 '0'、多一列全 '0'  
        // base condition
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;

        int height = matrix.length;
        int width = matrix[0].length;
        int maxSide = 0;

        // 相当于已经预处理新增第一行、第一列均为0
        int[][] dp = new int[height + 1][width + 1];

        for (int row = 1; row <= height; row++) {
            for (int col = 1; col <= width; col++) {
                
                //matrix[row - 1][col - 1] == '0': dp[row][col] = 0
                if (matrix[row - 1][col - 1] == '1') {
                    dp[row][col] = Math.min(Math.min(dp[row - 1][col], dp[row][col - 1]), dp[row - 1][col - 1]) + 1;
                    maxSide = Math.max(maxSide, dp[row][col]);
                }
            }
        }
        return maxSide * maxSide;
    }
}