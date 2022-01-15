class Solution {
    public int climbStairs(int n) {
        int[] M = new int[n + 1];
        M[0] = 1;
        M[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i - 1 >= 0) {
                M[i] = M[i - 1];
            }
            if (i - 2 >= 0) {
                M[i] += M[i - 2];
            }
        }
        return M[n];
    }
}