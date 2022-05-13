class Solution {
    public int maximalRectangle(char[][] matrix) {
        // 1 0 0      1 0 0
        // 1 1 1  ->  2 1 1   height matrix
        // 1 1 1      3 2 2
        // for each '1' in matrix, find the left and right bound in height matrix, and we can calculate the area
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] height = new int[m][n];
        //first row
        for (int i = 0; i < n; i++) {
            if(matrix[0][i] == '1') {
                height[0][i] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[i][j] = height[i - 1][j] + 1;
                } else {
                    height[i][j] = 0;
                }
            }
        }
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(height[i][j]);
        //     }
        //     System.out.println();
        // }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (height[i][j] != 0) {
                    int left = j;
                    //not include left
                    while (left >= 0 && height[i][left] >= height[i][j]) {
                        left--;
                    }
                    int right = j;
                    while (right < n && height[i][right] >= height[i][j]) {
                        right++;
                    }
                    res = Math.max(res, (right - left - 1) * height[i][j]);
                }
            }
        }
        return res;
    }
}