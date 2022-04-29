class Solution {
    /*
    for each level
        for up side
        for right
        for down
        for left
    */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = m - 1;
        while (left <= right && up <= down) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            up++;
            for (int i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left && up <= down; i--) {
                res.add(matrix[down][i]);
            }
            down--;
            for (int i = down; i >= up && left <= right; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }
}