class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 1;
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int cur = num;
            int cnt = 0;
            while (set.contains(cur)) {
                cnt++;
                cur = cur + 1;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}