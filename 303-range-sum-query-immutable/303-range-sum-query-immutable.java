class NumArray {
    int[] prefixSum;
    int[] num;
    public NumArray(int[] nums) {
        prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
       //  num = new int[nums.length];
       // for (int i = 0; i < nums.length; i++) {
       //     num[i] = nums[i];
       // }
        num = nums;
    }
    
    public int sumRange(int left, int right) {
        return prefixSum[right] - prefixSum[left] + num[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */