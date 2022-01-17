class Solution {
    //sliding window
    public double findMaxAverage(int[] nums, int k) {
//         int curr = 0;
//         int max = Integer.MIN_VALUE;

//         for(int i = 0; i < nums.length; i++){
//         	curr += nums[i];
//         	if(i - k  >=0) curr -= nums[i-k];
//         	if(i >= k-1 )max = Math.max(curr,max);
//         }
//         return (double)max/k;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < k - 1; i++) {
            sum += nums[i];
        }
        for (int i = k - 1; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            sum -= nums[i - k + 1];
        }
        return (double)maxSum / k;
    }
}