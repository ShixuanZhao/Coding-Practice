class Solution {
    public int ways(String[] pizza, int k) {
        int m = pizza.length;
        int n = pizza[0].length();
        int[][] sum = new int[m+1][n+1];
        int mod = (int)(1e9+7);

        //post sum
        for(int i = m-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {
                sum[i][j]=sum[i+1][j]+sum[i][j+1]-sum[i+1][j+1];//area_A + area_B - (area_A ⋂ area_B)
                sum[i][j]+=pizza[i].charAt(j) == 'A' ? 1 : 0;
            }
        }

        int[][][] dp = new int[k+1][m][n];
        //base case
        for(int i = m-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {
                if (sum[i][j] > 0) dp[1][i][j]=1;
            }
        }

        //bottom up dp
        for(int i = 2; i <= k; i++) {
            for(int j = m-1; j >= 0; j--) {
                for(int l = n-1; l >= 0; l--) {
                    for(int x = j+1; x < m; x++) {
                        if (sum[j][l] - sum[x][l] > 0)
                            dp[i][j][l] = (dp[i][j][l] + dp[i-1][x][l])%mod;
                    }
                    for(int x = l+1; x < n; x++) {
                        if (sum[j][l] - sum[j][x] > 0)
                            dp[i][j][l] = (dp[i][j][l] + dp[i-1][j][x])%mod;
                    }
                }
            }
        }

        return dp[k][0][0];
    }
}