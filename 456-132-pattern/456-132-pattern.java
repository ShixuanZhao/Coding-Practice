class Solution {
    public boolean find132pattern(int[] nums) {
        // 从后往前维护一个单调递减栈 若出现了栈顶元素比当前元素小的情况 说明找到了一个中间元素 大于它后面的元素 与此同时由于单调栈的特性我们维护的这个“后面的元素”会尽可能大，只要存在一个前面的元素比它小即可
        Deque<Integer> stack = new ArrayDeque<>();
        int s3 = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < s3) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peekFirst()) {
                s3 = stack.pollFirst();
            }
            stack.offerFirst(nums[i]);
        }
        return false;
    }
}