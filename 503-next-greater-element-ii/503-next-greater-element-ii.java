class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //想象成把原有的array copy了一遍放在后面形成一个大的array，size=2n，遍历index到2n-1，每次取模来获取元素
        //stack store the index
        //do not forget to initialize tp -1
        
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        int n = nums.length;
        for (int i = 0; i <= 2 * n - 1; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peekFirst()]) {
                res[stack.pollFirst()] = nums[i % n];
            }  
                stack.offerFirst(i % n);
        }
        return res;
    }
}