class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            map.putIfAbsent(e[0], new ArrayList<>());
            map.get(e[0]).add(e[1]);
            map.putIfAbsent(e[1], new ArrayList<>());
            map.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        if (dfs(0, -1, visited, map)) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
    
    //if has cycle return true
    private boolean dfs(int cur, int prev, boolean[] visited, Map<Integer, List<Integer>> map) {
        if (visited[cur]) {
            return true;
        }
        visited[cur] = true;
        for (int nei : map.getOrDefault(cur, new ArrayList<>())) {
            if (nei != prev && dfs(nei, cur, visited, map)) {
                return true;
            }
        }
        return false;
    }
}