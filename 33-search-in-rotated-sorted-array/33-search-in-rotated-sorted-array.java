class Solution {
    // public int search(int[] nums, int target) {
    //     //用二分查找，每次二分，一定有一边是有序的，另一边如果旋转点不是中间
    //     //另一边是无序的。在有序的那一边可以binary search，（根据min的值和边界
    //     //条件可以判断哪一边是有序的），无序的那边先不处理，等待着继续切割
    //     int left = 0;
    //     int right = nums.length - 1;
    //     //精确的找到某一个值，所以left<=right,一个数的时候也要进入循环判断
    //     while (left <= right) {
    //         int mid = left + (right - left) / 2;
    //         if (nums[mid] == target) {
    //             return mid;
    //         }
    //         //nums[mid] > nums[right] !! not left eg:[3,1] T = 1 比如array直接下降我们就应该
    //         if (nums[mid] >= nums[left]) {
    //             if (nums[left] <= target && target < nums[mid]) {
    //                 right = mid - 1;
    //             } else {
    //                 left = mid + 1;
    //             }
    //         } else {
    //             if (nums[mid] < target && target <= nums[right]) {
    //                 left = mid + 1;
    //             } else {
    //                 right = mid - 1;
    //             }
    //         }
    //     }
    //     return -1;
    // }
    
    //begin > end
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //left part is in ascending order
            if (nums[mid] > nums[left]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid;
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