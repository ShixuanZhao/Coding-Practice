class Solution {
    //Sliding window with at most one 0 inside.
    public int longestSubarray(int[] nums) {
        int left = 0;
        int cntZero = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cntZero++;
            }
            while (cntZero > 1) {
                if (nums[left] == 0) {
                    cntZero--;
                }
                left++;
            }
            //delete one ele
            res = Math.max(res, i - left);   
        }
        return res;
    }
}