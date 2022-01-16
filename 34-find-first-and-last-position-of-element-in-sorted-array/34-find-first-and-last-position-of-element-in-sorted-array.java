class Solution {
    /*
    this method has been dumped
    // Input: nums = [5,7,7,8,8,10], target = 8
    // Output: [3,4]
    // high level: I can use binary search to find the target because the nums are sorted
    // details:the first 8 is the first element larger than 7(target - 1)
    // the last 8 is the (index of the first element larger than 8) - 1
    // helper: find the index of first element larger than target
    // [1 2 3] T = 4 return nums.length
    // [3 4 5] T = 1 return -1;
    // [5,7,7,8,8,10]  T = 8
    */
    public int[] searchRange(int[] nums, int target) {
       if (nums == null || nums.length == 0) {
           return new int[] {-1, -1};
       }
        int left = bs1(nums, target);
        int right = bs2(nums, target);
        if (left != -1 && right != -1) {
            return new int[] {left, right};
        }
        return new int[] {-1, -1};
    }
    
    //the fisrt index of target
    private int bs1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        } else if (nums[right] == target) {
            return right;
        } else {
            return -1;
        }
    }
    
    //the last index of target
    private int bs2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                //if nums[mid] == target, we also need to shrink to left bound
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[right] == target) {
            return right;
        } else if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }
}