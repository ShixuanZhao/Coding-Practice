class Solution {
    //M[i]: the min coin to make up amount i
    //M[i] = Min(M[j]) + 1 j = i - all the possible coins value, and we can reach j
    public int coinChange(int[] coins, int amount) {
        int[] M = new int[amount + 1];
        Arrays.fill(M, Integer.MAX_VALUE);
        M[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && M[i - coin] != Integer.MAX_VALUE) {
                    M[i] = Math.min(M[i], M[i - coin] + 1);
                }
            }
        }
        return M[amount] != Integer.MAX_VALUE ? M[amount] : -1;
    }
}