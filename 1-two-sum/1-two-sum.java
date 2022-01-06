class Solution {
    public int[] twoSum(int[] nums, int target) {
        //two pointers O(nlogn)
        //WRONG because we want to find the index but after sorting the index of each value has been changed
        // Arrays.sort(nums);
        // int i = 0;
        // int j = nums.length - 1;
        // while (i <= j) {
        //     if (nums[i] + nums[j] < target) {
        //         i++;
        //     } else if (nums[i] + nums[j] > target) {
        //         j--;
        //     } else {
        //         return new int[] {i, j};
        //     }
        // }
        // return null;
        
        //HashMap O(n)
        //key:value value:index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[] {map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}