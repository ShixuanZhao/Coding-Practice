class Solution {
    /*
    corner case: k == 0
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
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                //this is the reason why we must use hashmap instead of hashset
                if (entry.getValue() >= 2) {
                    count++;
                } 
            } else {
                //search only in one direction
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        
        return count;
    }
}