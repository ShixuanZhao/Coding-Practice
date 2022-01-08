class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }
                    grid[x][y] = 2;
                    q.offer(new int[] {x, y});
                    fresh--;
                }
            }
            step++;
        }
        //step是遍历的层数最后要减1
        return fresh == 0 ? step - 1 : -1;
    }
}