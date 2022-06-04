class TicTacToe {
    int[] r;
    int[] c;
    int diag;
    int antiDiag;
    public TicTacToe(int n) {
        r = new int[n];
        c = new int[n];
    }
    
    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;
        r[row] += toAdd;
        c[col] += toAdd;
        if (row == col) {
            diag += toAdd;
        }
        int size = r.length;
        if (row == size - 1 - col) {
            antiDiag += toAdd;
        }
        if (Math.abs(r[row]) == size || Math.abs(c[col]) == size || Math.abs(diag) == size || Math.abs(antiDiag) == size) {
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */