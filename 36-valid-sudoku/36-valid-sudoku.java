class Solution {
    // public boolean isValidSudoku(char[][] board) {
    //     //decode the information(value + position) as string
    //     Set<String> set = new HashSet<>();
    //     for (int i = 0; i < board.length; i++) {
    //         for (int j = 0; j < board[0].length; j++) {
    //             char c = board[i][j];
    //             if (c != '.') {
    //                 if (!set.add(c + "row" + i) || !set.add(c + "col" + j) || !set.add(c + "block" + i / 3 + j / 3)) {
    //                     return false;
    //                 }
    //             }
    //         }
    //     }
    //     return true;
    // }
    
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                //add the row, col, block info to set
                //if contains in set, we return false
                if (c != '.') {
                    if (!set.add(c + " in row" + i) ||
                        !set.add(c + " in col" + j) ||
                        !set.add(c + " in block" + i / 3 + '-' + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}