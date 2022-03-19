class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            sum -= nums[i];
            if (prefixSum == sum) {
                return i;
            }
            prefixSum = prefixSum + nums[i];
        }
        return -1;
    }
}