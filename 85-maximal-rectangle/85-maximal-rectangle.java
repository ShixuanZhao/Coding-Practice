class Solution {
    //DP
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
    
    // public int maximalRectangle(char[][] matrix) {
        //利用84的解法，对于每一行调用一次
    //     int row = matrix.length;
    //     if (row == 0) {
    //         return 0;
    //     }
    //     int col = matrix[0].length;
    //     int res = 0;
    //     int[] heights = new int[col];
    //     for (int i = 0; i < row; i++) {
    //         for (int j = 0; j < col; j++) {
    //             if (matrix[i][j] == '1') {
    //                 heights[j] += 1;
    //             } else {
    //                 heights[j] = 0;
    //             }
    //         }
    //         res = Math.max(largestRectangleArea(heights), res);
    //     }
    //     return res;
    // }

    // private int largestRectangleArea(int[] heights) {
    //     int result = 0;
    //     //we store the index in the stack
    //     Deque<Integer> stack = new ArrayDeque<>();
    //     //人为的在最后设置一个高度为0的矩形，为了能弹出stack中所有元素
    //     for (int i = 0; i <= heights.length; i++) {
    //         int cur = i == heights.length ? 0 : heights[i];
    //         //当cur <= stack顶元素，右边界可以确定，更新res；
    //         //注意是while循环,对stack操作注意stack不是空
    //         //注意=也可以
    //         while (!stack.isEmpty() && cur <= heights[stack.peekFirst()]) {
    //             int height = heights[stack.pollFirst()];
    //             //corner case:第一个元素
    //             int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
    //             //右边界就是i, [)
    //             result = Math.max(result, (i - left) * height);
    //         }
    //         //!!!!do not forget
    //         stack.offerFirst(i);
    //     }
    //     return result;
}