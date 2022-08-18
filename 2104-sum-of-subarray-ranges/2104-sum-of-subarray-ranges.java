class Solution {
    /*
    Solution 0, Brute Force
Time O(n^3)
Space O(1)

Solution 1, Two Loops Solution
Time O(n^2)
Space O(1)

Solution 2, O(n) Stack Solution
    */
    public long subArrayRanges(int[] nums) {
        long res = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            //min:min from i to j, same as max
            int min = nums[i];
            int max = nums[i];
            for (int j = i + 1; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                res += max - min;
            }
        }
        return res;
    }
}