class Solution {
    /*
    minLen:3
    [2,3,1,2,4,3]
               f
           s
    curSum:6
    when to move slow:curSum > target
    */
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int slow = 0;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            while (curSum >= target) {
                minLen = Math.min(minLen, i - slow + 1);
                curSum -= nums[slow];
                slow++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}