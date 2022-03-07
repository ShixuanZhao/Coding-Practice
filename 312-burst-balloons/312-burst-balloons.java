class Solution {
    // dp[i][j]: coins obtained from bursting all the balloons between index i and j (not including i or j)
    //nums[i] and nums[j] are not been bursted
    // dp[i][j] = max(nums[i] * nums[k] * nums[j] + dp[i][k] + dp[k][j]) (k in (i+1,j))
    public int maxCoins(int[] nums) {
        int[] nums1 = new int[nums.length + 2];
        nums1[0] = 1;
        nums1[nums1.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            nums1[i + 1] = nums[i];
        }
        //System.out.println(nums1.toString());
        int n = nums1.length;
        int[][] M = new int [n][n];
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                //enum k, k is the ballon we shoud keep, and burst it last step
                for (int k = i + 1; k < j; k++) {
                    M[i][j] = Math.max(M[i][j], nums1[i] * nums1[k] * nums1[j] + M[i][k] + M[k][j]);
                }
                //System.out.println(M[i][j]);
            }
        }
        return M[0][n - 1];
    }
}