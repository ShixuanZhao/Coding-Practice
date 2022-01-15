class Solution {
    public boolean canJump(int[] nums) {
        //make a diff from leetcode746
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
        
        //M2 is wrong!! we must traverse from right to left
        // M[0] = true;
        // for (int i = 1; i < n; i++) {
        //     for (int j = 1; j <= nums[i]; j++) {
        //         if (i - j >= 0 && M[i - j]) {
        //             M[i] = true;
        //             break;
        //         }
        //     }
        // }
        // return M[n - 1];
    }
}