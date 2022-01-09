class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = nums[0];
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                prev += 1;
            } else {
                prev = 0;
            }
            res = Math.max(res, prev);
        }
        return res;
    }
}