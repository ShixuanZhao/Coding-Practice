class Solution {
     public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length, leftSum = 0, rightSum = Arrays.stream(nums).sum();
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            res[i] = i * nums[i] - leftSum + rightSum - (n - i) * nums[i];
            leftSum += nums[i];
            rightSum -= nums[i];
        }
        return res;
    }
}