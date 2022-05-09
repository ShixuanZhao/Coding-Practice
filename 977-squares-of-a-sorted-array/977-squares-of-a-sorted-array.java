class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int[] res = new int[n];
        int index = n - 1;
        while (i <= j) {
            if (Math.abs(nums[i]) < Math.abs(nums[j])) {
                res[index--] = nums[j] * nums[j];
                j--;
            } else {
                res[index--] = nums[i] * nums[i];
                i++;
            }
        }
        return res;
    }
}