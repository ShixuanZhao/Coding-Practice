class Solution {
    //time and space V+E
     public int minimumSemesters(int N, int[][] relations) {
        Map<Integer, List<Integer>> g = new HashMap<>(); // key: prerequisite, value: course list. 
        int[] inDegree = new int[N + 1]; // inDegree[i]: number of prerequisites for i.
        for (int[] r : relations) {
            g.computeIfAbsent(r[0], l -> new ArrayList<>()).add(r[1]); // construct graph.
            ++inDegree[r[1]]; // count prerequisites for r[1].
        }
        Queue<Integer> q = new LinkedList<>(); // save current 0 in-degree vertices.
        for (int i = 1; i <= N; ++i)
            if (inDegree[i] == 0)
                q.offer(i);
        int step = 0;
        Set<Integer> set = new HashSet<>();
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                set.add(cur);
                for (int nei : g.getOrDefault(cur, new ArrayList<>())) {
                    if (--inDegree[nei] == 0) {
                        q.offer(nei);
                    }
                }
            }
            step++;
        }
         return set.size() == N ? step : -1; 
    }
}