class Solution {
    //M[i]: the min coin to make up amount i
    //M[i] = Min(M[j]) + 1 j = i - all the possible coins value, and we can reach j
    public int coinChange(int[] coins, int amount) {
        //jump game similiar
        //M[i]凑i的钱数最少需要的coin数量
        int[] M = new int[amount + 1];
        Arrays.fill(M, Integer.MAX_VALUE);
        M[0] = 0;
        for (int i = 1; i <= amount; i++) {
            //右小段是一枚硬币
            for (int coin : coins) {
                if (i >= coin && M[i - coin] != Integer.MAX_VALUE) {
                    M[i] = Math.min(M[i], M[i - coin] + 1);
                }
            }
        }
        return M[amount] == Integer.MAX_VALUE ? -1 : M[amount];
    }
    //M2:无限背包，int[coins.length + 1][amount + 1]
    //j是空间容量,if j is valid M[i][j] = Math.min(M[i - 1][j], M[i][j - coins[i - 1]] + 1)
}