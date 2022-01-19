class Solution {
    /*
    Case 1. The first is that the subarray take only a middle part, and we know how to find the max subarray sum.
Case2. The second is that the subarray take a part of head array and a part of tail array.
We can transfer this case to the first one.
The maximum result equals to the total sum minus the minimum subarray sum.
corner case:If all numbers are negative, maxSum = max(A) and minSum = sum(A).
In this case, max(maxSum, total - minSum) = 0, which means the sum of an empty subarray.
According to the deacription, We need to return the max(A), instead of sum of am empty subarray.
So we return the maxSum to handle this corner case.
    */
    public int maxSubarraySumCircular(int[] nums) {
        int total = nums[0];
        int maxSum = nums[0];
        int prevMax = nums[0];
        int minSum = nums[0];
        int prevMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prevMax < 0) {
                prevMax = nums[i];
            } else {
                prevMax = prevMax + nums[i];
            }
            maxSum = Math.max(maxSum, prevMax);
            if (prevMin > 0) {
                prevMin = nums[i];
            } else {
                prevMin = prevMin + nums[i];
            }
            minSum = Math.min(minSum, prevMin);
            total += nums[i];
        }
        return maxSum < 0 ? maxSum : Math.max(maxSum, total - minSum);
    }
}