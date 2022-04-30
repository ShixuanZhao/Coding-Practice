class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[0];
        }
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        boolean isUp = true;
        int i = 0;
        int row = 0;
        int col = 0;
        while (row < m && col < n) {
            if (isUp) {
                while (row > 0 && col < n - 1) {
                    res[i++] = mat[row][col];
                    row--;
                    col++;
                }
                //boundary 1 or 3
                res[i++] = mat[row][col];
                if (col == n - 1) {
                    row++;
                } else {
                    col++;
                }
            } else {
                while (row < m - 1 && col > 0) {
                    res[i++] = mat[row][col];
                    row++;
                    col--;
                }
                //boundary, 4 or 8 are different cases
                res[i++] = mat[row][col];
                if (row == m - 1) {
                    col++;
                } else {
                    row++;
                }
            }
            isUp = !isUp;
        }
        return res;
    }
}