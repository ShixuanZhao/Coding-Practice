class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] M = new int[n + 1];
        M[0] = 0;
        M[1] = 0;
        for (int i = 2; i <= n; i++) {
            M[i] = Math.min(M[i - 1] + cost[i - 1], M[i - 2] + cost[i - 2]);
        }
        return M[n];
    }
}