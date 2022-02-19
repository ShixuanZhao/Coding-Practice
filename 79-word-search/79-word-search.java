class Solution {
    /*
        //dfs
        
    */
    private static final int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; 
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //boolean[][] visited = new boolean[m][n] is wrong
                //每次dfs之后又恢复原样了
                if (dfs(board, word, i, j, visited, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, boolean[][] visited, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if (dfs(board, word, nextI, nextJ, visited, index + 1)) {
                return true;
            }
        }
        visited[i][j] = false;
        //all the directions are not valid
        return false;
    }
}