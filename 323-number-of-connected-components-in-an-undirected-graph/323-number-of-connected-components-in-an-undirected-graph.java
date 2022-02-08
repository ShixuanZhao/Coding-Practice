class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n <= 1) {
            return n;
        }
        int m = edges.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            int s = e[0];
            int t = e[1];
            map.putIfAbsent(s, new ArrayList<>());
            map.get(s).add(t);
            map.putIfAbsent(t, new ArrayList<>());
            map.get(t).add(s);
        }
        int res = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(map, visited, i);
                res++;
            }
        }
        return res;
    }
    
    //岛屿数量
    private void dfs(Map<Integer, List<Integer>> map, Set<Integer> visited, int i) {
        if (visited.contains(i)) {
            return;
        }
        visited.add(i);
        for (int nei : map.getOrDefault(i, new ArrayList<>())) {
            dfs(map, visited, nei);
        }
    }
}