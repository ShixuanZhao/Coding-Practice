class Solution {
    static final int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, visited, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    //T = O(N * 4^L) where NN is the number of cells in the board and LL is the length of the word to be matched.
    //4个方向所以是4叉树
    private boolean dfs(char[][] board, String word, int i, int j, boolean[][] visited, int index) {
        int m = board.length;
        int n = board[0].length;
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (dfs(board, word, x, y, visited, index + 1)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}