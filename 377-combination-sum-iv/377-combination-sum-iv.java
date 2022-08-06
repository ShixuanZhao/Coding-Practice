class Solution {
    ////无限背包，每个元素可以重复用
    //coin change,每个元素只能用一次是01背包
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] M = new int[target + 1];
        M[0] = 1;
        for (int i = 1; i <= target; i++) {
            ////j 是右小段，右小段是一个数字，这样算的话肯定会有重读其实是permutation问题
            for (int j = 0; j < n; j++) {
                if (nums[j] <= i) {
                    M[i] += M[i - nums[j]];
                }
            }
        }
        return M[target];
    }
}