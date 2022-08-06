class Solution {
    /*
    max[i]: the max sun from index 0 to index i
    if max[i - 1] < 0 max[i] = arr[i]
    else max[i] = max[i - 1] + arr[i]
    return globalMax
    */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] M = new int[n];
        M[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            if (M[i - 1] < 0) {
                M[i] = nums[i];
            } else {
                M[i] = M[i - 1] + nums[i];
            }
            max = Math.max(max, M[i]);
        }
        return max;
    }
}