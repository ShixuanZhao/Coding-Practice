class Solution {
    /*
    
    If there is no duplicate in the array, we can map each indexes to each numbers in this array. In other words, we can have a mapping function f(index) = number
For example, let's assume
nums = [2,1,3], then the mapping function is 0->2, 1->1, 2->3.
If we start from index = 0, we can get a value according to this mapping function, and then we use this value as a new index and, again, we can get the other new value according to this new index. We repeat this process until the index exceeds the array. Actually, by doing so, we can get a sequence. Using the above example again, the sequence we get is 0->2->3. (Because index=3 exceeds the array's size, the sequence terminates!)

However, if there is duplicate in the array, the mapping function is many-to-one.
For example, let's assume
nums = [2,1,3,1], then the mapping function is 0->2, {1,3}->1, 2->3. Then the sequence we get definitely has a cycle. 0->2->3->1->1->1->1->1->........ The starting point of this cycle is the duplicate number.
     0 1 2 3 4
    [1,3,4,2,2]  converted to arr to cycle linkedlist
    1-3-2-4-2-4-2...
    arr[0]-arr[arr[0]]...
    */
    // public int findDuplicate(int[] nums) {
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
//         for (int i = 0; i < nums.length; i++) {
//             while (i != nums[i] - 1) {
//                 if (nums[i] == nums[nums[i] - 1]) {
//                     return nums[i];
//                 }
//                 swap(nums, i, nums[i] - 1);
//             }
//         }
//         return -1;
//     }
    
//     private void swap(int[] nums, int i, int j) {
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
        
    //find the intersction of a cycle linkedlist
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        //一定有环，所以while true
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                fast = nums[0];
                while (slow != fast) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return slow;
            }
        }
    }
    
    //guess the ans by using binary search
//     public int findDuplicate(int[] nums) {
//         //the ans is between [left, right]
//         //left mid right are num instead of index
//         int left = 1;
//         int right = nums.length - 1;
//         while (left < right) {
//             int mid = left + (right - left) / 2;
//             int cnt = countInRange(nums, left, mid);
//             //重复的在左边
//             if (cnt > mid - left + 1) {
//                 right = mid;
//             } else {
//                 left = mid + 1;
//             }
//         }
//         return left;
//     }
    
//     //遍历arr，把所有 start <= x <= end的x都挑出来
//     private int countInRange(int[] nums, int start, int end) {
//         int cnt = 0;
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] >= start && nums[i] <= end) {
//                 cnt++;
//             }
//         }
//         return cnt;
//     }
}