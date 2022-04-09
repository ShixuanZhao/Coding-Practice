class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            int curLen = 1;
            int temp = nums[i];
            if (!set.contains(temp - 1)) {
                while (set.contains(temp + 1)) {
                    temp = temp + 1;
                    curLen++;
                }
            }
            res = Math.max(res, curLen);
        }
        return res;
    }
}