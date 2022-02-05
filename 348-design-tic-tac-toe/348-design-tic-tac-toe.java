// The key observation is that in order to win Tic-Tac-Toe you must have the entire row or column. Thus, we don't need to keep track of an entire n^2 board. We only need to keep a count for each row and column. If at any time a row or column matches the size of the board then that player has won.

// To keep track of which player, I add one for Player1 and -1 for Player2. There are two additional variables to keep track of the count of the diagonals. Each time a player places a piece we just need to check the count of that row, column, diagonal and anti-diagonal.
class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;
    
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }
    
    //player1:add 1 player2:add -1
    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;
        rows[row] += toAdd;
        cols[col] += toAdd;
        if (row == col) {
            diagonal += toAdd;
        }
        //row + col = size - 1
        if (col == cols.length - row - 1) {
            antiDiagonal += toAdd;
        }
        int size = rows.length;
        if (Math.abs(rows[row]) == size ||
            Math.abs(cols[col]) == size ||
            Math.abs(diagonal) == size  ||
            Math.abs(antiDiagonal) == size) {
            return player;
        }
        //tie no player wins
        return 0;
    }
    
    /*
    another design:int[] row1//row1[i] represent how many chess have been put on row[i] for player1
                    int[] row2
    //int player if player == 1, meaning player1 is playing, so we should operate on row1 col1 and dia1, antidia1
    return :if player1 win, return 1;
            if palyer2 win, return 2;
            if no one win, return 0;
    */
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */