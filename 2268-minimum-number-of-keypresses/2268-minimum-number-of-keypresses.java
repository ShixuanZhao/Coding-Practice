class Solution {
    /*
    a1 p2 l1 e1
    put all letter into a maxHeap, compataror is based on the freq
    pop all ele in the maxHeap, put the most freq char on the first place
    res += (number of letter we have placed) / 9 + 1
    */
    public int minimumKeypresses(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue((a, b) -> (map.get(b) - map.get(a)));
        for (char c : map.keySet()) {
            pq.add(c);
        }
        int res = 0;
        //number of unique char we have placed on the keypad
        int cnt = 0;
        while (!pq.isEmpty()) {
            char c = pq.poll();
            int freq = map.get(c);
            res += freq * (cnt / 9 + 1);
            cnt++;
        }
        return res;
    }
}