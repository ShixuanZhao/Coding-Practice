class Solution {
    public int missingElement(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        //from left ro right, the number of missing ele
        int missing = nums[right] - nums[left] - (right - left);
        if (k > missing) {
            return nums[right] + k - missing;
        }
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            missing = nums[mid] - nums[left] - (mid - left);
            if (missing < k) {
                left = mid;
                k -= missing;
            } else {
                right = mid;
            }
        }
        //the missing number is between left and right
        return nums[left] + k;
    }
}