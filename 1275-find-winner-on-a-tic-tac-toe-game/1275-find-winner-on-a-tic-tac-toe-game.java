class Solution {
    int[] row = new int[3];
    int[] col = new int[3];
    int dia = 0;
    int antiDia = 0;
    public String tictactoe(int[][] moves) {
        for (int i = 0; i < moves.length; i++) {
            int r = moves[i][0];
            int c = moves[i][1];
            if (i % 2 == 0) {
                //A plays, add 1
                if (++row[r] == 3 || ++col[c] == 3 || r == c && ++dia == 3 || r + c == 2 && ++antiDia == 3) {
                    return "A";
                }
            } else {
                //B plays, minus 1
                if (--row[r] == -3 || --col[c] == -3 || r == c && --dia == -3 || r + c == 2 && --antiDia == -3) {
                    return "B";
                }
            }
        }
        return moves.length == 9 ? "Draw" : "Pending"; 
    }
}