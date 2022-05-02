class Solution {
    public static final int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new ArrayDeque<>();
        int m = rooms.length;
        int n = rooms[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    q.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || rooms[x][y] == -1) {
                    continue;
                }
                q.offer(new int[] {x, y});
                visited[x][y] = true;
                rooms[x][y] = rooms[cur[0]][cur[1]] + 1;
            }
        }
    }
}