class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        dfs(graph, res, path, 0);
        return res;
    }
    
    private void dfs(int[][] graph, List<List<Integer>> res, List<Integer> path, int i) {
        int n = graph.length;
        if (i == n - 1) {
            path.add(i);
            res.add(new LinkedList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        path.add(i);
        for (int nei : graph[i]) {
            dfs(graph, res, path, nei);
        }
        path.remove(path.size() - 1);
    }
}