class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //start from upper-right corner, it is a BST,
        //so it is search a target in BST
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}