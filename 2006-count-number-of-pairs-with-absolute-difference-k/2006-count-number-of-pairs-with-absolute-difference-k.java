class Solution {
    /*
    [1,2,2,1]
           i
    check i + k in the map
    res:2+2 = 4
    map: 1 2
    val  2 2
    
    */
    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int num : nums) {
            if (map.containsKey(num + k)) {
                res += map.get(num + k);
            }
        }
        return res;
    }
}