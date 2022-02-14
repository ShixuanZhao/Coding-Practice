class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            map.putIfAbsent(e[0], new ArrayList<>());
            map.get(e[0]).add(e[1]);
            map.putIfAbsent(e[1], new ArrayList<>());
            map.get(e[1]).add(e[0]);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(source);
        visited.add(source);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == destination) {
                return true;
            }
            for (int nei : map.getOrDefault(cur, new ArrayList<>())) {
                if (visited.add(nei)) {
                    q.offer(nei);
                }
            }
        }
        return false;
    }
}