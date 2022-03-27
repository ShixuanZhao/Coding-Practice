class FreqStack {
    /*
    5 7 5 4 
    pop:5 7
    
Hash map freq will count the frequence of elements.
Hash map m is a map of stack.
If element x has n frequence, we will push x n times in m[1], m[2] .. m[n]
maxfreq records the maximum frequence.
    */
    //<ele, freq>
    Map<Integer, Integer> freq;
    //<freq, all ele have this freq>
    Map<Integer, Deque<Integer>> map;
    int maxFreq;
    public FreqStack() {
        freq = new HashMap<>();
        map = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        maxFreq = Math.max(maxFreq, f);
        map.putIfAbsent(f, new ArrayDeque<>());
        map.get(f).offerFirst(val);
    }
    
    public int pop() {
        int res = map.get(maxFreq).pollFirst();
        freq.put(res, freq.get(res) - 1);
        if (map.get(maxFreq).size() == 0) {
            maxFreq--;
        }
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */