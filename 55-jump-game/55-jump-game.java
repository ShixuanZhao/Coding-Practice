class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int n = nums.length;
        boolean[] M = new boolean[n];
        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= n - 1) {
                M[i] = true;
            } else {
                for (int j = 1; j <= nums[i]; j++) {
                    if (M[i + j]) {
                        M[i] = true;
                        break;
                    }
                }
            }
        }
        return M[0];
    }
}