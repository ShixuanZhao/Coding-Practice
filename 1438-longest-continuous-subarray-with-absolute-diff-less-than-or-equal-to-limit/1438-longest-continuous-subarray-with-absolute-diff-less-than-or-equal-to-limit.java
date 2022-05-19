class Solution {
    //lc239
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxd = new ArrayDeque<>();
        Deque<Integer> mind = new ArrayDeque<>();
        //sliding window, i is slow, j is the fast
        int i = 0, j;
        for (j = 0; j < nums.length; ++j) {
            while (!maxd.isEmpty() && nums[j] > maxd.peekLast()) maxd.pollLast();
            while (!mind.isEmpty() && nums[j] < mind.peekLast()) mind.pollLast();
            maxd.add(nums[j]);
            mind.add(nums[j]);
            if (maxd.peek() - mind.peek() > limit) {
                if (maxd.peek() == nums[i]) maxd.poll();
                if (mind.peek() == nums[i]) mind.poll();
                ++i;
            }
        }
        return j - i;
    }
}