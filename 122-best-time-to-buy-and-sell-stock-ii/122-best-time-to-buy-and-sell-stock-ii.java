class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] M = new int[prices.length][2];
        //M[i][0]:the max profit when I hold the stock at day[i] .M[i][1]:do not hold the stock at day[i]
        M[0][0] = -prices[0];
        M[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            M[i][0] = Math.max(M[i - 1][0], M[i - 1][1] - prices[i]);
            M[i][1] = Math.max(M[i - 1][0] + prices[i], M[i - 1][1]);
        }
        //on the last day, we can not hold the stock to get max profit
        return M[prices.length - 1][1];
    }
}