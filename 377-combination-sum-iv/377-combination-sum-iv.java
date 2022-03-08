class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] M = new int[target + 1];
        M[0] = 1;
        /*
        T = 3 (1, 2)  (2, 1)
        */
        for (int i = 1; i < M.length; i++) {
            //j 是右小段，右小段是一个数字，这样算的话肯定会有重读其实是permutation问题
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    M[i] += M[i - nums[j]];
                }
            }
        }
        return M[target];
    }
}