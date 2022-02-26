class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> firstIndex = new HashMap<>();
        int degree = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            firstIndex.putIfAbsent(nums[i], i);
            if (freq.get(nums[i]) > degree) {
                degree = freq.get(nums[i]);
                res = i - firstIndex.get(nums[i]) + 1;
            } else if (freq.get(nums[i]) == degree) {
                res = Math.min(res, i - firstIndex.get(nums[i]) + 1);
            }
        }
        return res;
    }
}