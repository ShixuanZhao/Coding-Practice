class Solution {
    /*
    The greedy algorithm is that in each step, select the char with highest remaining count if possible (if it is not in the waiting queue). PQ is used to achieve the greedy. A regular queue waitQueue is used to "freeze" previous appeared char in the period of k.

In each iteration, we need to add current char to the waitQueue and also release the char at front of the queue, put back to maxHeap. The "impossible" case happens when the maxHeap is empty but there is still some char in the waitQueue.
    */
     public String rearrangeString(String s, int k) {
        if(k==0) return s;
        int[] freq = new int[26];
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) freq[c - 'a']++;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(int i = 0; i < 26; i++) if(freq[i] > 0) pq.add(new int[]{i, freq[i]});
        Queue<int[]> q = new LinkedList<>();
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            ans.append((char)(current[0] + 'a'));
            current[1]--;
            q.add(current);
            if (q.size() >= k) { 
                int[] front = q.poll();
                if (front[1] > 0) pq.add(front);
            }
        }
        return ans.length() == s.length() ? ans.toString() : "";
    } 
}