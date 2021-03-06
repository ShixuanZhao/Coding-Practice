class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }
    
    //define the return type is boolean is important
    private boolean dfs(char[][] board, int i, int j) {
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
                //!!
                if (dfs(board, i, j + 1)) {
                    return true;
                }
                board[i][j] = '.';
            }
        }
        return false;
    }
    
    private boolean isValid(char[][]board, int r, int c, char n) {
        for (int i = 0; i < 9; i++) {
            //same row
            if (board[r][i] == n) {
                return false;
            }
            //same col
            if (board[i][c] == n) {
                return false;
            }
            //same block
            // 判断 3 x 3 方框是否存在重复
            //(r/3)*3代表9个block中每个block的起始行号0 3 6 i/3就是递增量从0到2.   列同理
            //其实就是先固定每个block最左上角元素的坐标，再递增
            //注意行不变的时候，列要递增，所以列的时候是i%3
            if (board[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == n) {
                return false;
            }
        }
        return true;
    }
}