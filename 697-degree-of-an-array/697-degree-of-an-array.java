class Solution {
//     One pass on A,
// For each different number a in A,
// we need to count its frequency and it first occurrence index.

// If a has the maximum frequency,
// update the degree = count[a] and res = i - first[A[i]] + 1.

// If a is one of the numbers that has the maximum frequency,
// update the res = min(res, i - first[A[i]] + 1)
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> firstIndex = new HashMap<>();
        int res = Integer.MAX_VALUE;
        int degree = 0;
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