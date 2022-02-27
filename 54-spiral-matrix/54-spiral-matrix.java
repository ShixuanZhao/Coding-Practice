class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        while (left <= right && up <= down) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            up++;
            //start from 6
            for (int i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            //notice the termination condition because it is possible that there is only one row or column at last
            //not add up <= down otherwise we would add duplicate number
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