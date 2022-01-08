class Solution {
    public int longestOnes(int[] nums, int k) {
        if (k >= nums.length) {
            return nums.length;
        }
        //the number of one in the window
        int one = 0;
        int slow = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                one++;
            }
            while (i - slow + 1 - one > k) {
                if (nums[slow] == 1) {
                   one--; 
                }
                slow++;
            }
            res = Math.max(res, i - slow + 1);
        }
        return res;
    }
}