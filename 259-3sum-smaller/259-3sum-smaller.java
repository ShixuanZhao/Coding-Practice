class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int cnt = 0;
        while (i <= nums.length - 3) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum >= target) {
                    right--;
                } else {
                    cnt += right - left;
                    left++;
                }
            }
            i++;
        }
        return cnt;
    }
}