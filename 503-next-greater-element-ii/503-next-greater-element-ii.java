class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //traverse forward, keep a decreasing stack
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peekFirst()]) {
                int index = stack.pollFirst();
                res[index] = nums[i % n];
            }
            stack.offerFirst(i % n);
        }
        return res;
    }
}