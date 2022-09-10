class Solution {
    // public boolean isConsecutive(int[] nums) {
    //     Arrays.sort(nums);
    //     for (int i = 0; i < nums.length - 1; i++) {
    //         if (nums[i] + 1 != nums[i + 1]) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    
    public boolean isConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        if (set.size() != nums.length) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return max - min + 1 == set.size();
    }
}