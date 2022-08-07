class Solution {
    /*
    ["wrt","wrf","er","ett","rftt"]
                      prev
                              cur
     1 compare the first diff letter
     construct the directed graph Map<Character, List<Character>> map, and indegree map
     t->f w->e  r->t e->r
     2 toponology sort with BFS
     
    */
    public String alienOrder(String[] words) {
        //If there are multiple solutions, return any of them.
        //so if there is only one word in the words, return any of them
        if (words == null || words.length == 0) {
            return "";
        }
        int n = words.length;
        Map<Character, List<Character>> map = new HashMap<>();
        //must use the indegree map
        //when bfs, only the indegree of one char become 0, it can be from q
        Map<Character, Integer> indegree = new HashMap<>();
        //indegree record all the char
        for (String word : words) {
            for (char c : word.toCharArray()) {
                map.putIfAbsent(c, new LinkedList<>());
                indegree.putIfAbsent(c, 0);
            }
        }
        for (int i = 1; i < n; i++) {
            String prev = words[i - 1];
            String cur = words[i];
            int j = 0;
            int k = 0;
            while (j < prev.length() && k < cur.length()) {
                if (prev.charAt(j) == cur.charAt(k)) {
                    j++;
                    k++;
                } else {
                    map.get(prev.charAt(j)).add(cur.charAt(k));
                    indegree.put(cur.charAt(k), indegree.get(cur.charAt(k)) + 1);
                    break;
                }
            }
            //apple app is invalid, return ""
            if (k == cur.length() && j < prev.length()) {
                return "";
            }
        }
        //beign to BFS
        Queue<Character> q = new LinkedList<>();
        for (Character c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                q.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char cur = q.poll();
            sb.append(cur);
            for (Character nei : map.getOrDefault(cur, new LinkedList<>())) {
                int cnt = indegree.get(nei);
                indegree.put(nei, --cnt);
                if (cnt == 0) {
                    q.offer(nei);
                }
            }
        }
        return sb.length() != indegree.size() ? "" : sb.toString();
    }
}