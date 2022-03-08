class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] M = new int[target + 1];
        M[0] = 1;
        for (int i = 1; i < M.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    M[i] += M[i - nums[j]];
                }
            }
        }
        return M[target];
    }
}