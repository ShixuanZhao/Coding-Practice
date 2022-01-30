class Solution {
    public int maximumSwap(int num) {
        //M1:brute force
        //从左往右遍历每个位置，找后面的比他的数字，相同的选最后一次出现的位置，swap
        char[] nums = String.valueOf(num).toCharArray();
        dfs(nums, 0);
        return Integer.valueOf(new String(nums));
    }
    
    private void dfs(char[] nums, int index) {
        if (index == nums.length) {
            return;
        }
        // try to find a number greater than the current
        // note, if there are several max numbers we need to take the last one,
        // e.g. 1993->9913 rather than 9193
        int maxIndex = index;
        for (int i = index + 1; i < nums.length; i++) {
            //>=
            if (nums[i] > nums[index] && nums[i] >= nums[maxIndex]) {
                maxIndex = i;
            }
        }
        //find
        if (maxIndex > index) {
            char temp = nums[index];
            nums[index] = nums[maxIndex];
            nums[maxIndex] = temp;
            return;
        }
        dfs(nums, index + 1);
    }
}