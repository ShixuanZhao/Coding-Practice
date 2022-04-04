class Solution {
//     This solution works because that cycles of numbers won't interwine.
// Each element will be visited once,
// Time O(N)
// Space O(N) (space can be O(1))
    public int arrayNesting(int[] nums) {
        int res = 0;
        boolean[] seen = new boolean[nums.length];
        for (int i : nums) {
            int cnt = 0;
            while (!seen[i]) {
                seen[i] = true;
                cnt++;
                i = nums[i];
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}