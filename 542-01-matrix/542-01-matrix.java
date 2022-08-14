class Solution {
//     Naive BFS invoked multiple times (Slow)
// Iterate over the matrix with a nested for-loop to find cells conatining 1
// Apply BFS algo on those cells -> pass those cells to a BFS helper to find distance to closest 0
// update the matrix cell with the distance

// Optimized BFS invoked only once (Fast)
// Instead of invoking BFS for each land cell to see how far we can get away from that source, we flip the problem.
// The flipped problem is to start from target (sea) and to figure our the closest source (land)
// This allows us to run a single BFS search that emerges from different places (all the targets aka all the zero cells) in the grid
   int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    //从每一个0开始多源BFS。最先到的肯定是距离最短的
    //逆向思维：要求每一个点到0的距离，现在BFS，求所有的0到每个点的距离，以为是层序遍历，所以最先到的就是最短的
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    //0的话距离就是0
                    queue.offer(new int[] {i, j});
                    res[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c]) {
                    continue;
                }   
                queue.offer(new int[] {r, c});
                res[r][c] = res[cell[0]][cell[1]] + 1;
                visited[r][c] = true;
            }
        }
        return res;
    }
}