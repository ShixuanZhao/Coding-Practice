class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // 把num分成2部分 正的在一起 负的在一起
        // a - b = target
        // a + b = sum
        // a = (target + sum) / 2
        // find subsequence sum == (target + sum) / 2
        //转换成背包问题了
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (target > sum || (target + sum) % 2 == 1) {
            return 0;
        }
        return subsetSum(nums, (target + sum) / 2);
    }
    
    //找nums有多少种subset方法合为target
    //the inner loop must be descending because we need previous round of M[i - n] not the current round
    //otherwise, there would be duplicate它所依赖的j-nums[i]不应该变
    //因为每个元素只能用一次，所以从大到小遍历
    private int subsetSum(int[] nums, int target) {
        if (target < 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        //有一种取法：所有的element都不取
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= 0; j--) {
                if (j - nums[i] >= 0) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }
}