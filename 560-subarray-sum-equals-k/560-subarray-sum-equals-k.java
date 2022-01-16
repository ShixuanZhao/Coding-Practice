class Solution {
    public int subarraySum(int[] nums, int k) {
        //similiar to 2SUM, prefixSum
        //------------
        //     p1  T   p2
        //p2 - p1 = target,找在map里面是否存在p2 - target
        //map： key ：prefixSum, value:有几个值是这样的prefixSum
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        map.put(0, 1);
        int res = 0;
        for (int num : nums) {
            prefixSum = prefixSum + num;
            res += map.getOrDefault(prefixSum - k, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return res;
    }
}