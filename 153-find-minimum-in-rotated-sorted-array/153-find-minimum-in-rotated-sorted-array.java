class Solution {
    /*
      max
    
  1   / \
    /    \
          \ 
           \  /  2
            \/
            min
            begin > end
    from max 直接到 Min 中间是没有点的，在1或者2两段
    */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            //must compare with last ele, because when the arr is ascending, this case can pass
            if (nums[mid] < nums[nums.length - 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
    
    //wrong when the array is rotated n times, this case the arr would be keep in ascending order
    // public int findMin(int[] nums) {
    //     if (nums == null || nums.length == 0) {
    //         return Integer.MAX_VALUE;
    //     }
    //     int left = 0;
    //     int right = nums.length - 1;
    //     while (left < right - 1) {
    //         int mid = left + (right - left) / 2;
    //         if (nums[mid] > nums[0]) {
    //             left = mid;
    //         } else {
    //             right = mid;
    //         }
    //     }
    //     return Math.min(nums[left], nums[right]);
    // }
}