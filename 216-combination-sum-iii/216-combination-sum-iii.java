class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(res, cur, k, n, 1, 0);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> cur, int k, int n, int start, int sum) {
        if (cur.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            cur.add(i);
            dfs(res, cur, k, n, i + 1, sum + i);
            cur.remove(cur.size() - 1);
        }
    }
}