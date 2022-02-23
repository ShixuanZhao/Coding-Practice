class Solution {
    public int findDuplicate(int[] nums) {
        //有可能重复的数字出现多次
        //M1:HashSet
        // Set<Integer> set = new HashSet<>();
        // for (int num : nums) {
        //     if (!set.add(num)) {
        //         return num;
        //     }
        // }
        // return -1;
        
        //sort
        // Arrays.sort(nums);
        // for (int i = 0; i < nums.length - 1; i++) {
        //     if (nums[i] == nums[i + 1]) {
        //         return nums[i];
        //     }
        // }
        // return -1;
        
        //swap-swap
        /*
         0 1 2 3 4
        [1,2,3,4,2]
        */
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i] - 1) {
                if (nums[i] == nums[nums[i] - 1]) {
                    return nums[i];
                }
                swap(nums, i, nums[i] - 1);
            }
        }
        return -1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
        
        //best solution
        //O（n） O（1）
        //转换成find the start of circle in linkedlist
        // int slow = nums[0];
        // int fast = nums[0];
        // while (true) {
        //     slow = nums[slow];
        //     fast = nums[nums[fast]];
        //     if (slow == fast) {
        //         fast = nums[0];
        //         while (fast != slow) {
        //             slow = nums[slow];
        //             fast = nums[fast];
        //         }
        //         return slow;
        //     }
        // }
       
}