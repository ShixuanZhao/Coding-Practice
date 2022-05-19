class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            map.putIfAbsent(id, new PriorityQueue<Integer>());
            PriorityQueue<Integer> pq = map.get(id);
            if (pq.size() < 5) {
                pq.offer(score);
            } else if (score > pq.peek()) {
                pq.poll();
                pq.offer(score);
            }
        }
        int[][] res = new int[map.size()][2];
        int index = 0;
        for (int id : map.keySet()) {
            res[index][0] = id;
            PriorityQueue<Integer> pq1 = map.get(id);
            int sum = 0;
            while (!pq1.isEmpty()) {
                sum += pq1.poll();
            }
            res[index][1] = sum / 5;
            index++;
        }
        return res;
    }
}