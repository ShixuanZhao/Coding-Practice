class Solution {
    // int minCost = Integer.MAX_VALUE;
    // public int minCost(int[][] costs) {
    //     dfs(costs, 0, 0, -1);
    //     return minCost;
    // }
    // private void dfs(int[][]costs, int index, int sum, int prevColor) {
    //     int len = costs.length;
    //     if(index == len) {
    //         minCost = Math.min(minCost, sum);
    //         return;
    //     }
    //     if(sum > minCost)return;
    //     for(int i=0; i<3; i++ ) {
    //         if(i!=prevColor) {
    //             dfs(costs, index+1, sum+costs[index][i], i);
    //         }
    //     }
    // }
    
    /*
    M[i][j]:the min cost of the index i house is painted to color j
    M[i][0] = MIN(M[i - 1][1], M[i - 1][2]) + costs[i][0];
    ....
    ....
    need MIN(M[i - 1][0], M[i - 1][1], M[i - 1][2])
    */
    public int minCost(int[][] costs) {
        if(costs == null || costs.length < 1 || costs[0].length < 1) return 0;
        int n = costs.length;
        int[][] M = new int[n][3];
        for (int i = 0; i < 3; i++) {
            M[0][i] = costs[0][i];
        }
        for (int i = 1; i < n; i++) {
            M[i][0] = Math.min(M[i - 1][1], M[i - 1][2]) + costs[i][0];
            M[i][1] = Math.min(M[i - 1][0], M[i - 1][2]) + costs[i][1];
            M[i][2] = Math.min(M[i - 1][1], M[i - 1][0]) + costs[i][2];
        }
        return Math.min(Math.min(M[n - 1][0], M[n - 1][1]), M[n - 1][2]);
    }
}