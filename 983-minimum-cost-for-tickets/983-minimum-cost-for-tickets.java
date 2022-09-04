class Solution {
    /*
    dp[i] means up to i-th day the minimum cost of the tickets. The size of the dp array depends on the last travel day, so we don't need an array length to be 365.

We do need a boolean array to mark the travel days, the reason is if it is not a travel day we don't need a ticket. However, if it is a travel day, we consider three scenarios (with three types of tickects):

If a 1-day ticket on day i, dp[i] = dp[i - 1] + cost[0]
If a 7-day ticket ending on day i, dp[i] = min(dp[i - 7], dp[i - 6] ... dp[i - 1]) + cost[1]
If a 30-day ticket ending on day i, dp[i] = min(dp[i - 30], dp[i - 29] ... dp[i - 1]) + cost[2]

But since the value of dp array is increasing, therefore:
For a 7-day ticket ending on day i, dp[i] = dp[i - 7] + cost[1]
For a 30-day ticket ending on day i, dp[i] = dp[i - 30] + cost[2]
    */
     public int mincostTickets(int[] days, int[] costs) {
        // length up to the last travel + 1 day is good enough (no need for 365)
        int lastDay = days[days.length - 1]; 
        // dp[i] means up to i-th day the minimum cost of the tickets
        int[] dp = new int[lastDay + 1]; 
        boolean[] isTravelDays = new boolean[lastDay + 1];
        // mark the travel days
        for(int day : days) isTravelDays[day] = true;

        for(int i = 1; i <= lastDay; i++) {
            if(!isTravelDays[i]) { // no need to buy ticket if it is not a travel day
                dp[i] = dp[i - 1];
                continue;
            }
            // select which type of ticket to buy
            dp[i] = costs[0] + dp[i - 1]; // 1-day
            dp[i] = Math.min(costs[1] + dp[Math.max(i - 7, 0)], dp[i]); // 7-day
            dp[i] = Math.min(costs[2] + dp[Math.max(i - 30, 0)], dp[i]); // 30-day
        }
        return dp[lastDay];
    }
}