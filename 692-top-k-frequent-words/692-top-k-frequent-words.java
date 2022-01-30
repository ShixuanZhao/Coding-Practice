class Solution {
    /*
        clarify: if k > words.length, we should return all the words
        assumption: k > 0, k < words.length
        step1:traverse words[], use a HashMap to build the freqMap key is each word(String), value is the frequency(int)
        step2:use a pq to implement a minHeap which size == k, 
        traverse all the entry in map.if the size of minHeap < k, keeping offering
        else: if the freq of top element in minHeap < the freq of new element, pop and offer(new element)
                else: do not care
        step3:pop all the element in the minHeap and output the key, if we keep popping, the order would be from lowest to highest
        we should reverse the order
        T = O(n * logk) S = O(k)
    */
    public List<String> topKFrequent(String[] words, int k) {
        //step1
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        //define our pq, step2
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>((o1, o2) -> {
            if (o1.getValue() != o2.getValue()) {
                return o1.getValue() - o2.getValue();
            } else {
                //// 如果词频相同，根据字典序倒序，因为要pop出字典序大的
                return o2.getKey().compareTo(o1.getKey());
            }
        });
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else {
                //排除法，把频率小的排除，这样heap里面留的都是k个频率最大的
                if (minHeap.peek().getValue() < entry.getValue()) {
                    minHeap.poll();
                    minHeap.offer(entry);
                } else if (minHeap.peek().getValue() == entry.getValue() && entry.getKey().compareTo(minHeap.peek().getKey()) < 0) {                    //把heap里字典序大的排除，遇到小的push，这样剩下来的都是字典序小的
                    // 词频与堆顶元素相同 且字典序大小比堆顶元素小，弹出堆顶元素，入堆
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
        }
        //step3
        List<String> res = new ArrayList<String>(k);
        while (minHeap.size() > 0) {
            res.add(minHeap.poll().getKey());
        }
        // 注意最后需要反转元素的顺序。因为栈顶元素先pop出的是频率小的
        Collections.reverse(res);
        return res;
    }
}