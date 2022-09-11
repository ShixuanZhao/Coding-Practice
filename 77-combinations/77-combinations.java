class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        dfs(res, cur, n, k, 1);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> cur, int n, int k, int start) {
        if (cur.size() == k) {
            res.add(new LinkedList<>(cur));
        }
        for (int i = start; i <= n; i++) {
            cur.add(i);
            dfs(res, cur, n, k, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}