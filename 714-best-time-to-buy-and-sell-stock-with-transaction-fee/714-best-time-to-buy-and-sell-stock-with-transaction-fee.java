class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] M = new int[prices.length][2];
        //M[i][1]:the max profit when I hold the stock at day[i] .M[i][0]:do not hold the stock at day[i]
        // 这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
        //only need fee when selling
        M[0][1] = -prices[0];
        M[0][0] = 0;
        for (int i = 1; i < prices.length; i++) {
            M[i][1] = Math.max(M[i - 1][1], M[i - 1][0] - prices[i]);
            M[i][0] = Math.max(M[i - 1][1] + prices[i] - fee, M[i - 1][0]);
        }
        //on the last day, we can not hold the stock to get max profit
        return M[prices.length - 1][0];
    }
}