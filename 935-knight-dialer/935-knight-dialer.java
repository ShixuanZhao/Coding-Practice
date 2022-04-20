class Solution {
    public int knightDialer(int n) {
        //数字0可以由数字4和6得到
        //所以得到dp：newM[0] = oldM[4] + oldM[6]
        int paths[][]= { {4,6}, {6,8},{7,9}, {4,8}, {0,3,9}, {}, {1,7,0}, {2,6}, {1,3}, {2,4}};
        int mod = (int)1e9+7;
        //n次之后到数字0-9各有多少种方式
        int [] dp = new int[10];
        
        Arrays.fill(dp,1);
        
        for(int steps =2 ;steps<=n;steps++){
            int [] next = new int [10];
            for(int i=0;i<10;i++){
                for(int p : paths[i]){
                    next[i] = (next[i] + dp[p]) %mod;
                }
               
            }
            dp=next;
        }
        
        int ans =0;
        for(int num : dp){
            ans =(ans + num) % mod;
        }
        
        return ans % mod;
    }
}