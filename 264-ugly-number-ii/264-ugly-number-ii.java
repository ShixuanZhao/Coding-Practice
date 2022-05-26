class Solution {
    /*
    dp[i]:1 2 3 4 5 6 8
    for 2:2 4 6 8 10
    for 4:3 8 16
    for 5:5 10
    */
    public int nthUglyNumber(int n) {
        int[] M = new int[n];
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int val2 = 2;
        int val3 = 3;
        int val5 = 5;
        M[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Math.min(val2, Math.min(val3, val5));
            M[i] = min;
            if (min == val2) {
                val2 = 2 * M[++index2];
            }
            if (min == val3) {
                val3 = 3 * M[++index3];
            }
            if (min == val5) {
                val5 = 5 * M[++index5];
            }
        }
        return M[n - 1];
    }
}