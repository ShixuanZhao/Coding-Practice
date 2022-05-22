class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        //key is the prefixsum, val is the index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
            map.putIfAbsent(sum, i);
        }
        return maxLen;
    }
}