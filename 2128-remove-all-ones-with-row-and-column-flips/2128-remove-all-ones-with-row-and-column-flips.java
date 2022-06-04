class Solution {
    public boolean removeOnes(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //Scan the first row and flip if required
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) {
                for (int i = 0; i < m; i++) {
                    //flip the whole col
                    grid[i][j] = grid[i][j] == 1 ? 0 : 1;
                }
            }
        }
        //check whether other rows are same
        // we are done with the first row
        // now we can't filp columns again; that would mess up our first row
        // we can only filp rows now onwards; 
        // that means now following rows should have the same value in the whole row
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