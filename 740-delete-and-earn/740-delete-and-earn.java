class Solution {
//     The optimal final result can be derived by keep updating 2 variables skip_i, take_i, which stands for:
// skip_i : the best result for sub-problem of first (i+1) buckets from 0 to i, while you skip the ith bucket.
// take_i : the best result for sub-problem of first (i+1) buckets from 0 to i, while you take the ith bucket.

// DP formula:
// take[i] = skip[i-1] + values[i];
// skip[i] = Math.max(skip[i-1], take[i-1]);
/**
 * for numbers from [1 - 10000], each has a total sum sums[i]; if you earn sums[i], you cannot earn sums[i-1] and sums[i+1]
 * kind of like house robbing. you cannot rob 2 connected houses.
 * 
 */
    public int deleteAndEarn(int[] nums) {
        //the first [] is index, the second [] is choose or not chooose. 1 is choose
        int n = 10001;
        //the max value is 10000
        //index is number, val is sum of all this number
        int[] values = new int[n];
        int[][] M = new int[n][2];
        M[0][0] = 0;
        M[0][1] = values[0];
        for (int num : nums) {
            values[num] += num;
        }
        for (int i = 1; i < n; i++) {
            M[i][0] = Math.max(M[i - 1][0], M[i - 1][1]);
            M[i][1] = M[i - 1][0] + values[i];
        }
        return Math.max(M[n - 1][0], M[n - 1][1]);
    }
}