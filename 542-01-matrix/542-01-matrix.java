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
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    //0的话距离就是0
                    queue.offer(new int[] {i, j});
                }
                else {
                    //区分原来的1还是距离是1
                    //Integer.MAX_VALUE marked as unvisited
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                //if visited, continue
                if (r < 0 || r >= m || c < 0 || c >= n || 
                    mat[r][c] != Integer.MAX_VALUE) continue;
                queue.add(new int[] {r, c});
                mat[r][c] = mat[cell[0]][cell[1]] + 1;
            }
        }
        return mat;
    }
}