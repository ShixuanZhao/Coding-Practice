class Solution {
    public int findLengthOfLCIS(int[] nums) {
        //The idea is to use cnt to record the length of the current continuous increasing subsequence which ends with nums[i], and use res to record the maximum cnt.
        //longest inscreasing subarray 
        int res = 1;
        //prev ending with nums[i - 1], cur is at index i
        int cur = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cur += 1;
            } else {
                cur = 1;
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}