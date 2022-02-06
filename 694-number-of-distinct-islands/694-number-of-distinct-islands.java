class Solution {
    public int numDistinctIslands(int[][] grid) {
        // 首先，对于形状相同的岛屿，如果从同一起点出发，dfs函数遍历的顺序肯定是一样的
        // 相当于是岛屿序列化的结果，只要每次使用dfs遍历岛屿的时候生成这串数字进行比较，就可以计算到底有多少个不同的岛屿了。
        int m = grid.length, n = grid[0].length;
    // 记录所有岛屿的序列化结果
    HashSet<String> islands = new HashSet<>();
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 1) {
                // 淹掉这个岛屿，同时存储岛屿的序列化结果
                StringBuilder sb = new StringBuilder();
                // 初始的方向可以随便写，不影响正确性
                dfs(grid, i, j, sb, 666);
                islands.add(sb.toString());
            }
        }
    }
    // 不相同的岛屿数量
    return islands.size();
    }
    
    // 改造dfs函数，添加一些函数参数以便记录遍历顺序：
    // dir记录方向，dfs函数递归结束后，sb记录着整个遍历顺序
    void dfs(int[][] grid, int i, int j, StringBuilder sb, int dir) {
    int m = grid.length, n = grid[0].length;
    if (i < 0 || j < 0 || i >= m || j >= n 
        || grid[i][j] == 0) {
        return;
    }
    // 前序遍历位置：进入 (i, j)
    grid[i][j] = 0;
    sb.append(dir).append(',');

    dfs(grid, i - 1, j, sb, 1); // 上
    dfs(grid, i + 1, j, sb, 2); // 下
    dfs(grid, i, j - 1, sb, 3); // 左
    dfs(grid, i, j + 1, sb, 4); // 右

    // 后序遍历位置：离开 (i, j) !!!
    sb.append(-dir).append(',');
    }   
}