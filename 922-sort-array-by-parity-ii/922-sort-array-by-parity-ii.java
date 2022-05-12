class Solution {
    /*
     0 1 2 3
    [4,5,2,7]
             e
              o
              two pointers
    */
    public int[] sortArrayByParityII(int[] nums) {
        int even = 0;
        int odd = 1;
        int n = nums.length;
        while (even < n && odd < n) {
            while (even < n && nums[even] % 2 == 0) {
                even += 2;
            }
            while (odd < n && nums[odd] % 2 == 1) {
                odd += 2;
            }
            if (odd < n && even < n) {
                //swap
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
            }
        }
        return nums;
    }
}