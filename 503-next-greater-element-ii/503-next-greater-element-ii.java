class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //想象成把原有的array copy了一遍放在后面形成一个大的array，size=2n，遍历index到2n-1，每次取模来获取元素
        //stack store the index
        //do not forget to initialize tp -1
//         Loop once, we can get the Next Greater Number of a normal array.
// Loop twice, we can get the Next Greater Number of a circular array
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[stack.peekFirst()] < nums[i % n]) {
                res[stack.pollFirst()] = nums[i % n];
            }
            stack.offerFirst(i % n);
        }
        return res;
    }
}