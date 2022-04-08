class Solution {
    /*
    high level: dfs
    recursion tree:
             root
    L0     2        3      6    7
    L1  2 3 6 7   3 6 7   6 7   7 if sum == target, we can return
       ........
    L(size)
    */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(res, cur, candidates, target, 0, 0, 0);
        return res;
    }
    
    //help us debug dfs problem
    // int cnt = 0;
    // private void printIndent(int n) {
    //     for (int i = 0; i < n; i++) {
    //         System.out.print("  ");
    //     }
    // }
    
    private void helper(List<List<Integer>> res, List<Integer> cur, int[] candidates, int target, int index, int sum, int begin) {
        //base case
        //because we know all the element in the array is positive, we can trum
        // printIndent(++cnt);
        // System.out.print(sum);
        // System.out.println(cur.toString());
        if (target < sum) {
            // printIndent(--cnt);
            // System.out.print(sum);
            // System.out.println(cur.toString());
            return;
        }   
        if (sum == target) {
            res.add(new ArrayList<>(cur));
            // printIndent(--cnt);
            // System.out.print(sum);
            // System.out.println(cur.toString());
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            sum += candidates[i];
            cur.add(candidates[i]);
            helper(res, cur, candidates, target, index + 1, sum, i);
            sum -= candidates[i];
            cur.remove(cur.size() - 1);
        }
    }
}