class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] M = new int[amount + 1];
        Arrays.fill(M, Integer.MAX_VALUE);
        M[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && M[i - coins[j]] != Integer.MAX_VALUE) {
                    M[i] = Math.min(M[i], M[i - coins[j]] + 1);
                }
            }
        }
        return M[amount] == Integer.MAX_VALUE ? -1 : M[amount];
    }
}