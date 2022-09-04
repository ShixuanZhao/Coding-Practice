class Solution {
    //相当于我们自己编写哈希函数，这个哈希函数的规则特别简单，那就是数值为 i 的数映射到下标为 i - 1 的位置
    /*
    Numbers greater then n can be ignored because the missing integer must be in the range 1..n+1
        we will establish a mapping: we should place nums[i] to the index i - 1
        if not, we keep swaping,then we scan nums again, find the first missing positive
         0 1  2 3 
        [1,-1,3,4]   
        step1: swap the element to the right position according to our mapping
        step2:scan it and find the wrong index, and return index + 1
         0 1 2 3
        [1,2,2,4]
    */
    public int firstMissingPositive(int[] nums) {
        //assume there are not duplicate numbers
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] - 1 >= 0 && nums[i] - 1 < n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (i + 1 != nums[i]) {
                return i + 1;
            }
        }
        return n + 1;
    }
    
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}