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
        if (words == null || words.length == 0) {
            return "";
        }
        Map<Character, List<Character>> map = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        //must be initialize to every unique char
        for (String word : words) {
            for (char c : word.toCharArray()) {
                map.putIfAbsent(c, new LinkedList<>());
                indegree.putIfAbsent(c, 0);
            }
        }
        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String cur = words[i];
            //corner case:apple app is invalid return ""
            int j = 0;
            for (; j < Math.min(prev.length(), cur.length()); j++) {
                if (prev.charAt(j) != cur.charAt(j)) {
                    map.get(prev.charAt(j)).add(cur.charAt(j));
                    indegree.put(cur.charAt(j), indegree.getOrDefault(cur.charAt(j), 0) + 1);
                    break;
                }
            }
            if (j == cur.length() && cur.length() < prev.length()) {
                return "";
            }
        }
        //System.out.println(map.size());
        //System.out.println(indegree.size());
        //BFS
        Queue<Character> q = new ArrayDeque<>();
        for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                q.offer(entry.getKey());
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char c = q.poll();
            //System.out.println(c);
            sb.append(c);
            for (char nei : map.getOrDefault(c, new LinkedList<>())) {
                indegree.put(nei, indegree.get(nei) - 1);
                if (indegree.get(nei) == 0) {
                    q.offer(nei);
                }
            }
        }
        return sb.length() != indegree.size() ? "" : sb.toString();
    }
}