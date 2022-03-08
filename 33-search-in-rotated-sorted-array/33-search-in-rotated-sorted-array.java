class Solution {
    //begin > end
     //     //用二分查找，每次二分，一定有一边是有序的，另一边如果旋转点不是中间
    //     //另一边是无序的。在有序的那一边可以binary search，（根据min的值和边界
    //     //条件可以判断哪一边是有序的），无序的那边先不处理，等待着继续切割
    //根据题意，永远都是上升下降再上升，不存在单调的情况
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //compare with nums[left] also work
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
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
}