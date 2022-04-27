class AutocompleteSystem {
    class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> cnt;
        TrieNode() {
            children = new HashMap<>();
            cnt = new HashMap<>();
        }
    }
    
    TrieNode root = new TrieNode();
    String prefix = "";
    public AutocompleteSystem(String[] sentences, int[] times) {
        //build Trie
        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }
    
    //search
    public List<String> input(char c) {
        if (c == '#') {
            add(prefix, 1);
            prefix = "";
            return new ArrayList<>();
        }
        prefix += c;
        TrieNode cur = root;
        for (char cc : prefix.toCharArray()) {
            if (cur.children.get(cc) == null) {
                return new ArrayList<>();
            }
            cur = cur.children.get(cc);
        }
        List<String> res = new ArrayList<>();
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((a, b) -> {
            if (a.getValue() == b.getValue()) {
                return a.getKey().compareTo(b.getKey());
            }
            return b.getValue() - a.getValue();
        });
        pq.addAll(cur.cnt.entrySet());
        int k = 3;
        while (!pq.isEmpty() && k > 0) {
            res.add(pq.poll().getKey());
            k--;
        }
        return res;
    }
    
    private void add(String word, int time) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
            cur.cnt.put(word, cur.cnt.getOrDefault(word, 0) + time);
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */