class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            //must compare with right ele, because when the arr is ascending, this case can pass
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                //nums[mid] = nums[left] = nums[right]
                //333333133
                //we should remove 1 ele,must remove right
                //because if the nums is not rotated, like 122222
                //remove left would exclude 1
                right--;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}