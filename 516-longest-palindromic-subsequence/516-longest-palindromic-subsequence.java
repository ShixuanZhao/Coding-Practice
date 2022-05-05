class Solution {
    /*
        dp[i][j]: the longest palindromic subsequence's length of substring(i, j), here i, j represent left, right indexes in the string
State transition:
dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
Initialization: dp[i][i] = 1
    */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] M = new int[n][n];
        //M[i][i] = 0
        //根据dp rule的关系：i需要i+1，i从后往前，j需要j-1，j从前往后
        for (int i = n - 1; i >= 0; i--) {
            M[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    M[i][j] = M[i + 1][j - 1] + 2;
                } else {
                    M[i][j] = Math.max(M[i+1][j], M[i][j-1]);
                }
            }
        }
        return M[0][n - 1];
    }
}