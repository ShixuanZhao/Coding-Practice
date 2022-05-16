class Solution {
    //和lc 377做区分
//     public int change(int amount, int[] coins) {
//         //M[i]: the number of way og amount i
//         //M[i] += M[i - coin[j]] coin[j] is the right little part i > coim[j]
//         int[] M = new int[amount + 1];
//         M[0] = 1;
//         //the outer loop should be coin instead of amount because we need to avoid duplicate combination eg (1, 2, 2) (2 1 2) (2 2 1)
//         //so we need to anchor one coin each time
//         //对于这个题是要求combination,元素之间没有顺序
// //         假设：coins[0] = 1，coins[1] = 5。

// // 那么就是先把1加入计算，然后再把5加入计算，得到的方法数量只有{1, 5}这种情况。而不会出现{5, 1}的情况。
//         // **所以这种遍历顺序中dp[j]里计算的是组合数！**
//         //如果题目问能不能凑成，那么遍历的顺序就无所谓了
//         //背包问题都是先遍历物品再遍历背包
//         //遍历从小到大因为是无限背包
//         for (int coin : coins) {
//             for (int i = 0; i <= amount; i++) {
//                 if (i >= coin) {
//                     M[i] += M[i - coin];
//                 }
//             }   
//         }
//         return M[amount];
//     }
    
    public int change(int amount, int[] coins) {
        //dp[i][j] : the number of combinations to make up amount j by using the first i types of coins
        int[][] M = new int[coins.length+1][amount+1];
        for (int i = 0; i <= coins.length; i++) {
            M[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] > j) {
                    M[i][j] = M[i - 1][j];
                } else {
                    //M[i][j - coins[i - 1]]用第i个coin
                    //not M[i - 1][j - coins[i - 1]] because you have an infinite number of each kind of coin.
                    M[i][j] = M[i - 1][j] + M[i][j - coins[i - 1]];
                }
            }
        }
        return M[coins.length][amount];
    }
}