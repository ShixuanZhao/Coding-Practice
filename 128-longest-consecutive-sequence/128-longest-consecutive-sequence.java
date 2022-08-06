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