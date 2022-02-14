class Solution {
    public int maxProfit(int[] prices) {
        //每一轮有三个状态：刚刚持有，持有一天和卖出
        if (prices == null || prices.length < 2) {
            return 0;
        }
        //由于可以无限次交易，所以只定义两个维度，第一个维度是天数，第二个维度表示是否持有股票，0表示不持有，1表示持有
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);
        for (int i = 2; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //冷却时间1天，所以要从 i - 2 天转移状态
            //买入，卖出 ---- 冷冻期 ----  买入，卖出
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]);
        }
        //最后最大利润为最后一天，不持有股票或者进入冷冻期的情况
        return dp[prices.length-1][0];
    }
}