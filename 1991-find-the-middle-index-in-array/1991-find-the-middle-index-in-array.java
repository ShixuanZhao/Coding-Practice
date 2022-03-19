class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        //sum is suffixSum
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            //suffixSum
            sum -= nums[i];
            if (prefixSum == sum) {
                return i;
            }
            prefixSum = prefixSum + nums[i];
        }
        return -1;
    }
}