class Solution {
    ///TLE
//     public void solveSudoku(char[][] board) {
//         dfs(board);
//     }
    
//     private boolean dfs(char[][] board) {
//         int m = board.length;
//         int n = board[0].length;
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (board[i][j] == '.') {
//                     for (char c = '1'; c <= '9'; c++) {
//                         if (isValid(board, i, j, c)) {
//                             board[i][j] = c;
//                             if (dfs(board)) {
//                                 return true;
//                             }
//                             board[i][j] = '.';
//                         }
//                     }
//                 }
//             }
//         }
//         return false;
//     }
    
//     private boolean isValid(char[][] board, int i, int j, char c) {
//         for (int row = 0; row < board.length; row++) {
//             if (board[row][j] == c) {
//                 return false;
//             }
//         }
//         for (int col = 0; col < board[0].length; col++) {
//             if (board[i][col] == c) {
//                 return false;
//             }
//         }
//         //there is mapping between i, j and row, col
//         for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {
//             for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++) {
//                 if (board[row][col] == c) {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }
    
    //(i, j) is the starting point
    private boolean dfs(char[][] board, int i, int j) {
        //base case
        int m = board.length;
        int n = board[0].length;
        if (i == m) {
            return true;
        }
        if (j == n) {
            return dfs(board, i + 1, 0);
        }
        if (board[i][j] != '.') {
            return dfs(board, i, j + 1);
        }
        for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, i, j, c)) {
                board[i][j] = c;
                if (dfs(board, i, j + 1)) {
                    return true;
                }
                board[i][j] = '.';
            }
        }
        return false;
    }
    
    private boolean isValid(char[][] board, int r, int c, char n) {
        for (int i = 0; i < 9; i++) {
            // 判断行是否存在重复
            if (board[r][i] == n) return false;
            // 判断列是否存在重复
            if (board[i][c] == n) return false;
            // 判断 3 x 3 方框是否存在重复
            //(r/3)*3代表9个block中每个block的起始行号0 3 6 i/3就是递增量从0到2.   列同理
            //其实就是先固定每个block最左上角元素的坐标，再递增
            //注意行不变的时候，列要递增，所以列的时候是i%3
            if (board[(r/3)*3 + i/3][(c/3)*3 + i%3] == n)
                return false;
        }
        return true;
    }
}