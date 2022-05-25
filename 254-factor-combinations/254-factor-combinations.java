class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(n, 2, res, cur);
        return res;
    }
    
    //去重2点：1，i * i <= n 2.每次从begin开始，前面选择的就不再选择了
    private void dfs(int n, int begin, List<List<Integer>> res, List<Integer> cur) {
        //make choice. in order to avoid duplication, we impose the start point
        //we need to begin variable
        for (int i = begin; i * i <= n; i++) {
            if (n % i == 0) {
                cur.add(i);
                cur.add(n / i);
                res.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
                //i because we can use duplicate number
                //把大的n /i继续拆
                dfs(n / i, i, res, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
}