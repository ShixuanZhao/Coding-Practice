class Solution {
    /*
    corner case: ascending arr return nums[0]
    compare the nums[mid] with nums[left]
    nums[mid] > nums[left] left = mid
    else right = mid
    0 1 2 3 4
    3 4 5 1 2
        l 
          
          r
    return the smaller one
    
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
        int n = nums.length;
        if (n == 0 || nums[0] < nums[n - 1]) {
            return nums[0];
        }
        int left = 0;
        int right = n - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[left] < nums[right] ? nums[left] : nums[right];
    }
}