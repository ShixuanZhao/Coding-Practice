class Solution {
   
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();
            if (x != y) {
                pq.offer(y - x);
            }
        }
        return pq.size() == 0 ? 0 : pq.peek();
    }
}