class Solution {
    /*
    dp[i] record the maximum sum we can get considering A[0] ~ A[i-1]
To get dp[i], we will try to change k last numbers separately to the maximum of them,
where k = 1 to k = K.
尝试所有可能的右小段，最后一个subarray的size是1,2...k
dp[i] = Max(dp[i - j] + max of subarray * j)
Solution 1, O(N) space
Time O(NK)
Space O(N)
    */
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] M = new int[n + 1];
        M[0] = 0;
        for (int i = 1; i <= n; i++) {
            int curMax = 0;
            //j is the size
            for (int j = 1; j <= k && i - j >= 0; j++) {
                //rolling max from right to left in the last subarray
                curMax = Math.max(curMax, arr[i - j]);
                M[i] = Math.max(M[i], M[i - j] + curMax * j);
            }
        }
        return M[n];
    }
}