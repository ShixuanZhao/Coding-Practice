class Solution {
    public int[][] candyCrush(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean stable  = true;
        //delete horizontally
        for (int i = 0; i < m; i++) {
            int j = 0;
            while (j + 2 < n) {
                int target = Math.abs(board[i][j]);
                if (board[i][j] != 0 && Math.abs(board[i][j + 1]) == target && Math.abs(board[i][j + 2]) == target) {
                    stable = false;
                    
                    while (j < n && Math.abs(board[i][j]) == target) {
                        board[i][j] = -target;
                        j++;
                    }
                    
                } else {
                    j++;
                }
            }
        }
        //delete vertically
        for (int j = 0; j < n; j++) {
            int i = 0;
            while (i + 2 < m) {
                int target = Math.abs(board[i][j]);
                if (board[i][j] != 0 && Math.abs(board[i + 1][j]) == target && Math.abs(board[i + 2][j]) == target) {
                    stable = false;
                    int k = i;
                    while (k < m && Math.abs(board[k][j]) == target) {
                        board[k][j] = -target;
                        k++;
                    }
                    i = k;
                } else {
                    i++;
                }
            }
        }
        //falling
        //botton:1 2 -3 -3 -3 1 0 0 -> 1 2 1 0 0 0 0 0
        //botton:1 2  1 -3 -3 1 0 0 -> 1 2 1 0 0 0 0 0
        //                      i
        //              j
        if (!stable) {
            for (int j = 0; j < n; j++) {
                //i aim to find the first 0
                int i = m - 1;
                //below pointer p is all the settled down ele
                int p = m - 1;
                //two pointers
                while (i >= 0 && board[i][j] != 0) {
                    if (board[i][j] > 0) {
                        board[p][j] = board[i][j];
                        p--;
                    }
                    i--;
                }
                while (p >= 0) {
                    board[p][j] = 0;
                    p--;
                }
            }
        }
        return stable ? board : candyCrush(board);
    }
}