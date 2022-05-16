class Solution {
     public boolean canPartition(int[] nums) {
//         把问题转化为背包问题：

// 给一个可装载重量为 sum / 2 的背包和 N 个物品，每个物品的重量为 nums[i]。现在让你装物品，是否存在一种装法，能够恰好将背包装满？
        int sum = Arrays.stream(nums).sum();
        //this step cannot be ignored, sum必须是偶数
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        int n = nums.length;
        //2D 01 package
        // 状态就是「背包的容量」和「可选择的物品」，选择就是「装进背包」或者「不装进背包」。
        //     比如说，如果 dp[4][9] = true，其含义为：对于容量为 9 的背包，若只是用前 4 个物品，可以有一种方法把背包恰好装满。
        boolean[][] M = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            M[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                // 背包容量不足，不能装入第 i 个物品
                M[i][j] = M[i - 1][j];
                } else {
                    // 装入或不装入背包M[i - 1][j - nums[i - 1]] i - i not i because each ele can 
                    //only be used once
                    M[i][j] = M[i - 1][j] || M[i - 1][j - nums[i - 1]];
                }
            }
            
        }
        return M[n][sum];
    }
    
    //1D 01背包
    // public boolean canPartition(int[] nums) {
    //     int sum = Arrays.stream(nums).sum();
    //     //this step cannot be ignored, sum必须是偶数
    //     if (sum % 2 != 0) {
    //         return false;
    //     }
    //     sum /= 2;
    //     boolean[] M = new boolean[sum + 1];
    //     M[0] = true;
    //     for (int num : nums) {
    //         //必须从大到小遍历，当前轮依赖于上一轮而不是当前轮，滚动数组的滚动方向
    //         for (int i = sum; i >= num; i--) {
    //             M[i] = M[i] || M[i - num];
    //         }
    //     }
    //     return M[sum];
    // }
    
    
    //TLE
//     public boolean canPartition(int[] nums) {
//         int sum = Arrays.stream(nums).sum();
//         //this step cannot be ignored, sum必须是偶数
//         if (sum % 2 != 0) {
//             return false;
//         }
//         return dfs(nums, sum / 2, 0, 0);
//     }
    
//     private boolean dfs(int[] nums, int target, int index, int sum) {
//         if (sum > target) {
//             return false;
//         }
//         if (sum == target) {
//             return true;
//         }
//         for (int i = index; i < nums.length; i++) {
//             if (dfs(nums, target, i + 1, sum + nums[i])) {
//                 return true;
//             }
//         }
//         return false;
//     }
}