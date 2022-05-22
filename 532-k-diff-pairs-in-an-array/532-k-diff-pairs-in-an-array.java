class Solution {
    /*
    corner case: k == 0
    [3,1,4,1,5]
    freqMap  key: 3 1 4 5
             val: 1 2 1 1
    */
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int res = 0;
        //because we need unique pair, so we need to iterate hashmap
        for (int num : map.keySet()) {
            //if k == 0, we need to chech the freq must >=2
            if (k == 0) {
                if (map.get(num) >= 2) {
                    res++;
                }
            } else {
                if (map.containsKey(num + k)) {
                    res++;
                }
            }
        }
        return res;
    }
}