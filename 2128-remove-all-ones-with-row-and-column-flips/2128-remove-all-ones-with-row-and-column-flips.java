class Solution {
    public boolean removeOnes(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) {
                for (int i = 0; i < m; i++) {
                    //flip the whole col
                    grid[i][j] = grid[i][j] == 1 ? 0 : 1;
                }
            }
        }
        //check whether other rows are same
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] != grid[i][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}