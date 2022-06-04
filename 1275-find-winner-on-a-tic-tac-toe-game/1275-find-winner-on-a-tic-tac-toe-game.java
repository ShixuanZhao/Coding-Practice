class Solution {
    int[] row = new int[3];
    int[] col = new int[3];
    int dia = 0;
    int antiDia = 0;
    public String tictactoe(int[][] moves) {
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) {
                //A plays, add 1
                row[moves[i][0]]++;
                col[moves[i][1]]++;
                if (moves[i][0] == moves[i][1]) {
                    dia++;
                }
                if (moves[i][0] == 2 - moves[i][1]) {
                    antiDia++;
                }
                if (row[moves[i][0]] == 3 || col[moves[i][1]] == 3 || dia == 3 || antiDia == 3) {
                    return "A";
                }
            } else {
                //B plays, minus 1
                row[moves[i][0]]--;
                col[moves[i][1]]--;
                if (moves[i][0] == moves[i][1]) {
                    dia--;
                }
                if (moves[i][0] == 2 - moves[i][1]) {
                    antiDia--;
                }
                if (row[moves[i][0]] == -3 || col[moves[i][1]] == -3 || dia == -3 || antiDia == -3) {
                    return "B";
                }
            }
        }
        if (moves.length < 9) {
            return "Pending";
        }
        return "Draw";
    }
}