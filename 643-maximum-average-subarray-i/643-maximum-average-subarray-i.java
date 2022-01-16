class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int curr = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
        	curr += nums[i];
        	if(i - k  >=0) curr -= nums[i-k];
        	if(i >= k-1 )max = Math.max(curr,max);
        }
        return (double)max/k;
    }
}