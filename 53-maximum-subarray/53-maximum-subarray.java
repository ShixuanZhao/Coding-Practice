class Solution {
    /*
    M[i]:the max sum ending at index i
    M[i] = M[i - 1] + nums[i] M[i - 1] > 0
            nums[i]           else
    keep a globalMax, update for each M[i]
    [-2,1,-3,4,-1,2,1,-5,4]
    */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] M = new int[n];
        M[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            if (M[i - 1] > 0) {
                M[i] = M[i - 1] + nums[i];
            } else {
                M[i] = nums[i];
            }
            res = Math.max(res, M[i]);
        }
        return res;
    }
}