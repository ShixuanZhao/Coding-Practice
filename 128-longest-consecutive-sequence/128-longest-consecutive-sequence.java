class Solution {
    /*
    [100,4,200,1,3,2]
               i
    check for each possible start, use a set to record all the ele
    keep checking for cur + 1 in the set 
    case1:cur - 1 is in the set || cur + 1 is not in the set, it means cur is  not the start
        ignore and check next ele
    case2:repeat and update the maxLen
    */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (set.contains(cur - 1) || !set.contains(cur + 1)) {
                continue;
            }
            int curLen = 1;
            while (i < nums.length && set.contains(cur + 1)) {
                cur = cur + 1;
                curLen++;
            }
            res = Math.max(res, curLen);
        }
        return res;
    }
}