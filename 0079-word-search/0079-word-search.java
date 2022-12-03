class Solution {
    static final int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, board, 0, word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(int i, int j, char[][] board, int index, String word, boolean[][] visited) {
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
            if (dfs(x, y, board, index + 1, word, visited)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}