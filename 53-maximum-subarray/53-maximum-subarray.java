class Solution {
    /*
        WRONG:because there are negative number in the array
        // two pointer: left and right
        // define a sliding window [left, right]
        // use a variable sum to record the sum in the window
        input:int[] num output: int
        clarify: num == null || num.length == 0
        return Integer.Min_VALUE;
        primitive: sunstring [left, right]
        for left 
           for right
              getSum: calculate the sum and update the max
       T = O(n^3)
       //dp 
       M[i]: the maxSum of subarray from index0 to index i(including)
       M[i] = if M[i - 1] > 0, M[i - 1] + nums[i]
               else ,          nums[i]
       inti:M[0] = nums[i];
        optimization:use a var prev to represent M[i - 1]
        T = O(n) S = O(1)
       
    */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int prev = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev < 0) {
                prev = nums[i];
            } else {
                prev += nums[i];
            }
            globalMax = Math.max(globalMax, prev);
        }
        return globalMax;
    }
}