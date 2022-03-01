class Solution {
    //双指针：类似three pointer固定一个，移动2个
    //Same as https://leetcode.com/problems/3sum-closest
    //Assume a is the longest edge, b and c are shorter ones, to form a triangle, they need to satisfy len(b) + len(c) > len(a).
    /*
    [2,2,3,4,5]
           i
     l
       r
    */
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        int res = 0;
        Arrays.sort(nums);
        for (int i = 2; i < n; i++) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    res += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}