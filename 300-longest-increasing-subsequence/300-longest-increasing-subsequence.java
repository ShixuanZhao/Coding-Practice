class Solution {
    /*
        M[i]:LIS from index0 to indexi(including)
          [10,9,2,5,3,7,101,18]
        M:  1 1 1 2 2 
        M[i] = Max(M[j]) + 1 nums[j] < nums[i]
    */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] M = new int[n];
        Arrays.fill(M, 1);
        int res = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    M[i] = Math.max(M[j] + 1, M[i]);
                }
            }
            res = Math.max(res, M[i]);
        }
        return res;
    }
}