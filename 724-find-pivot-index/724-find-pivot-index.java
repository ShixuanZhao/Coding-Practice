class Solution {
    //maintain two var: prefixSum and suffixSum, update them when tarversing the arr
    //at first, suffix is the sum
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        //sum is suffixSum
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
            if (sum == curSum) {
                return i;
            }
            //update prefixSum
            curSum += nums[i];
        }
        return -1;
    }
}