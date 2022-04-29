class Solution {
    public static final int[][] dirs = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new LinkedList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return res;
        }
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, 0);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j, 0);
        }
        for (int i = 0; i < m; i++) {
            dfs(heights, atlantic, i, n - 1, 0);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, atlantic,  m - 1, j, 0);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                     res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
    
    private void dfs(int[][] heights, boolean[][] canReach, int i, int j, int prev) {
        int m = heights.length;
        int n = heights[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || canReach[i][j] || heights[i][j] < prev) {
            return;
        }
        canReach[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            dfs(heights, canReach, x, y, heights[i][j]);
        }
    }
}