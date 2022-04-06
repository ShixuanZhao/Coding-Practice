class Solution {
    /*
    input: int[]
    output: int 
    clarify:num == null || length == 0 return 0
    freMap <num, freq>
    degree
    first_index_map <num, first index>
    [1,2,2,3,1]
         i
     freqMap:<1, 1> <2, 2>
     indexMap:<1, 0> <2, 1>
     indegree:2
     res:2
    */
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Integer> firstIndex = new HashMap<>();
        int res = 0;
        int degree = 0;
        for (int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
            firstIndex.putIfAbsent(nums[i], i);
            if (freqMap.get(nums[i]) > degree) {
                degree = freqMap.get(nums[i]);
                res = i - firstIndex.get(nums[i]) + 1;
            } else if (freqMap.get(nums[i]) == degree) {
                res = Math.min(res, i - firstIndex.get(nums[i]) + 1);
            }
        }
        return res;
    }
}