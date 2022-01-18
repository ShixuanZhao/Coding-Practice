class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0;
        int right = n - 1;
        //Obviously, you could merge colStart and colEnd into rowStart and rowEnd because it is a square matrix. But this is easily extensible to matrices that are m*n.
        int up = 0;
        int down = n - 1;
        int x = 1;
        while (left <= right && up <= down) {
            for (int i = left; i <= right; i++) {
                res[up][i] = x++;
            }
            up++;
            for (int i = up; i <= down; i++) {
                res[i][right] = x++;;
            }
            right--;
            for (int i = right; i >= left; i--) {
                res[down][i] = x++;
            }
            down--;
            for (int i = down; i >= up; i--) {
                res[i][left] = x++;
            }
            left++;
        }
        return res;
    }
}