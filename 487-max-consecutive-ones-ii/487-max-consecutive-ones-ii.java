class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int zero = 0;
        int slow = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            }
            while (zero > 1) {
                if (nums[slow] == 0) {
                    zero--;
                }
                slow++;
            }
            res = Math.max(res, i - slow + 1);
        }
        return res;
    }
}