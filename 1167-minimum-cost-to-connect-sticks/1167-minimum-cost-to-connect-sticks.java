class Solution {
    public int connectSticks(int[] sticks) {
        //greedy: first merge two smallest element because the early merged one will be calculated cost duplicately
        //default minHeap: from small to large
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int totalCost = 0;
        for (int cur : sticks) {
            minHeap.offer(cur);
        }
        while (minHeap.size() > 1) {
            int curCost = minHeap.poll() + minHeap.poll();
            minHeap.offer(curCost);
            totalCost += curCost;
        }
        return totalCost;
    }
}