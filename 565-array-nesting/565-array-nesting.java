class Solution {
//     This solution works because that cycles of numbers won't interwine.
// Each element will be visited once,
// Time O(N)
// Space O(N) (space can be O(1))
    public int arrayNesting(int[] nums) {
        int res = 0;
        int n = nums.length;
        boolean[] seen = new boolean[n];
        //may have multiple cycle
        //try every possible start 
        for (int num : nums) {
            int cnt = 0;
            while (!seen[num]) {
                cnt++;
                seen[num] = true;
                num = nums[num];
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}