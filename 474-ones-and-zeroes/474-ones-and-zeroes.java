class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1]; //M[m][n]是我们剩余空间为m n的时候
        //我们最多可以装多少个物品
        for (String s : strs) {
            int one = 0;
            int zero = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    one++;
                } else {
                    zero++;
                }
            }
            //只要目前剩余的空间比这个物品的空间大 我们可以选择拿，牺牲空间得到count + 1
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}