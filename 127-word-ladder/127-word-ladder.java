class Solution {
    /*
    
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        int step = 1;
        Set<String> visited = new HashSet<>();    
        q.offer(beginWord);
        visited.add(beginWord);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(endWord)) {
                    return step;
                }
                List<String> neiList = getNei(cur, dict);
                if (neiList.size() == 0) {
                    continue;
                }
                for (String nei : neiList) {
                    if (visited.add(nei)) {
                        q.offer(nei);
                    }
                }
            }
            step++;
        }
        return 0;
    }
    
    private List<String> getNei(String cur, Set<String> dict) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < cur.length(); i++) {
            StringBuilder sb = new StringBuilder(cur);
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == cur.charAt(i)) {
                    continue;
                }
                sb.setCharAt(i, c);
                String newWord = sb.toString();
                if (dict.contains(newWord)) {
                    res.add(newWord);
                }
            }
        }
        return res;
    }
}