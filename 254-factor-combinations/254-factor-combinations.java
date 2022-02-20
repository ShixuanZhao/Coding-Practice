class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(n, 2, res, cur);
        return res;
    }
    
    private void dfs(int n, int begin, List<List<Integer>> res, List<Integer> cur) {
        for (int i = begin; i * i <= n; i++) {
            if (n % i == 0) {
                cur.add(i);
                cur.add(n / i);
                res.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
                dfs(n / i, i, res, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
}