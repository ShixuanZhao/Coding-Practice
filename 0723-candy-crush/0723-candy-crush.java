class Solution {
    /*
    123333
    243456
    953285
    行和列的3都要删除，关键把3变成-3，技能保留原来的数值，负数也能表示是需要删除的
    */
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
                    //no need for k
                    int k = j;
                    while (k < n && Math.abs(board[i][k]) == target) {
                        board[i][k] = -target;
                        k++;
                    }
                    j = k;
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
                //p指向下一个可以被安放的位置
                int p = m - 1;
                //two pointers
                //每一列可以是+，-，0
                //正的要往下排放，负的是要被消除的，可以当成0
                //最往上面都是0，所以 !=0结束，再往上面都是0
                while (i >= 0 && board[i][j] != 0) {
                    if (board[i][j] > 0) {
                        board[p][j] = board[i][j];
                        p--;
                    }
                    i--;
                }
                //再往上面都是0
                while (p >= 0) {
                    board[p][j] = 0;
                    p--;
                }
            }
        }
        //需要重新检查一遍 After the above steps, there may exist more candies that can be crushed. If so, you need to repeat the above steps.
        return stable ? board : candyCrush(board);
    }
}