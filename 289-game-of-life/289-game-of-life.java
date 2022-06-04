class Solution {
    //scan the 3 * 3 region including the current cell, count how many cells are live
    //a cell will live in the next generation if lives == 3 || lives == 4 && cell == 1 
    //otherwise, the cell will dead
    //for 32bit Integer, use the 2nd lowest position to store the status of next generation
    // Remember that the board needs to be updated simultaneously
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = 0;
                for (int x = Math.max(0, i - 1); x <= Math.min(m - 1, i + 1); x++) {
                    for (int y = Math.max(0, j - 1); y <= Math.min(n - 1, j + 1); y++) {
                        lives += board[x][y] & 1;
                    }
                }
                if (lives == 3 || lives == 4 && board[i][j] == 1) {
                    //bit setter
                    board[i][j] |= 0b10; 
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) { 
                board[i][j] >>= 1;     
            }
        }
    }
}