class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //nums1 is a subset of nums2
        //next greater element
        //key is x, value is next greater element
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int x : nums2) {
            while (!stack.isEmpty() && x > stack.peekFirst()) {
                map.put(stack.pollFirst(), x);
            }
            stack.offerFirst(x);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}