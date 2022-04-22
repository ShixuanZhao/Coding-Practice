class Solution {
    /*
    sliding window of size the number of total one
    the number of swap is the number of zero in each window
    [1,0,1,0,1]
         i
             j
    */
    public int minSwaps(int[] data) {
        int n = data.length;
        int ones = 0;
        for (int i = 0; i < n; i++) {
            if (data[i] == 1) {
                ones++;
            }
        }
        int left = 0;
        int res = Integer.MAX_VALUE;
        int zeros = 0;
        for (int i = 0; i < n; i++) {
            if (data[i] == 0) {
                zeros++;
            }
            while (i - left + 1 > ones) {
                if (data[left] == 0) {
                    zeros--;
                }
                left++;
            }
            if (i - left + 1 == ones) {
                res = Math.min(res, zeros);
            }
        }
        return res;
    }
}