class Solution {
    /*
    coins = [1,2,5], amount = 11
    M:0 1
    */
    public int coinChange(int[] coins, int amount) {
        int[] M = new int[amount + 1];
        Arrays.fill(M, Integer.MAX_VALUE);
        M[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin && M[i - coin] != Integer.MAX_VALUE) {
                    M[i] = Math.min(M[i], M[i - coin] + 1);
                }
            }
        }
        return M[amount] == Integer.MAX_VALUE ? -1 : M[amount];
    }
}