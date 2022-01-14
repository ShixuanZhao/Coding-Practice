class Solution {
    /*
    using a map to store the index of last occurrence for each number
    for each n
    if exists in map, check difference
    
    */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        //val to index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            //we always update to the latest index
            map.put(nums[i], i);
        }
        return false;
    }
}