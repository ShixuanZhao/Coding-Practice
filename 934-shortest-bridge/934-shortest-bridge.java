class Solution {
    public int shortestBridge(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        boolean isfound = false;
        for (int i = 0; i < m; i++) {
            if (isfound) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !isfound) {
                    //dfs find the island, put all connected '1' into q
                    dfs(grid, visited, q, i, j, dirs);
                    isfound = true;
                    break;
                }
            }
        }
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                // if (grid[x][y] == 1) {
                //     return step - 1;
                // }
                for (int[] dir : dirs) {
                    int X = x + dir[0];
                    int Y = y + dir[1];
                    if (X < 0 || X >= m || Y < 0 || Y >= n || visited[X][Y]) {
                        continue;
                    }
                    if (grid[X][Y] == 1) {
                        return step;
                    }
                    visited[X][Y] = true;
                    q.offer(new int[] {X, Y});
                }
            }
            step++;
        }
        return -1;
    }
    
    private void dfs(int[][] A, boolean[][] visited, Queue<int[]> q, int i, int j, int[][] dirs) {
        if (i < 0 || j < 0 || i >= A.length || j >= A[0].length || visited[i][j] || A[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        q.offer(new int[]{i, j});
        for (int[] dir : dirs) {
            dfs(A, visited, q, i + dir[0], j + dir[1], dirs);
        }
    }
}