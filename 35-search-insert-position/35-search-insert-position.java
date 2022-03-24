class Solution {
    /*
    1 3 5 6 T = 5
    l mid r
      1 3   5     6   case1   return 2
         l mid     r   
         
     1 3   4     6   T = 5  return 3
       l   mid    r
      1 3   4     6  A[l] < T < A[r]: return l + 1;  
             l     r
                         T < A[l]: return l;
                         T > A[r]: return r + 1
    */
    public int searchInsert(int[] nums, int target) {
        //nums contains distinct values sorted in ascending order.
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        //cannot be delete
        // [1,3]
        // 3 output 1 instead of 2
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid;
            } else if (target == nums[mid]) {
                return mid;
            } else {
                left = mid;
            }
        }
        if (nums[left] < target && target < nums[right]) {
            return right;
        } else if (target < nums[left]) {
            return left;
        } else {
            return right + 1;
        }    
    }
}