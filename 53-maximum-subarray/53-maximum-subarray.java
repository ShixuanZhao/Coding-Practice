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
        int pre = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            if (pre > 0) {
                pre = pre + nums[i];
            } else {
                pre = nums[i];
            }
            res = Math.max(res, pre);
        }
        return res;
    }
}