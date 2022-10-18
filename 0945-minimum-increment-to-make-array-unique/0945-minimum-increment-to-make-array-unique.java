class Solution {
    /*
    [3,2,1,2,1,7]
    1 1 2 2 3 7
    1 2 3 4 5 7
    
    Sort the input array.
Compared with previous number,
the current number need to be at least prev + 1.
    */
    public int minIncrementForUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int expect = prev + 1;
            if (expect > nums[i]) {
                res += expect - nums[i];
            }
            prev = Math.max(nums[i], expect);
        }
        return res;
    }
}