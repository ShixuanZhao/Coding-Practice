class Solution {
    /*
    interate the array, record the curSum, and store the prefixSum and its freq into HashMap
    for each ele, check whether we have k - curSum in map
    if have, update the res
    */
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            res = res + map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}