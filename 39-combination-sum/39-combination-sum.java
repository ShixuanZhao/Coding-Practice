class Solution {
    //false: because The same number may be chosen from candidates an unlimited number of times.
    //this solution deal with each number can be used only once
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> res = new ArrayList<>();
//         List<Integer> sub = new ArrayList<>();
//         dfs(res, sub, candidates, 0, 0, target);
//         return res;
//     }
    
//     private void dfs(List<List<Integer>> res, List<Integer> sub, int[] candidates, int index, int sum, int target) {
//         if (index == candidates.length) {
//             if (sum == target) {
//                 res.add(new ArrayList<>(sub));
//             }
//             return;
//         }
//         sum += candidates[index];
//         sub.add(candidates[index]);
//         dfs(res, sub, candidates, index + 1, sum, target);
//         sum -= candidates[index];
//         sub.remove(sub.size() - 1);
//         dfs(res, sub, candidates, index + 1, sum, target);
//     }
    
    /*
          root
       2       3      6   7
   2 3 6 7   3 6 7   6 7   7
    */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        dfs(res, sub, candidates, 0, 0, target);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> sub, int[] candidates, int startIndex, int sum, int target) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(sub));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            sub.add(candidates[i]);
            dfs(res, sub, candidates, i, sum, target);
            sum -= candidates[i];
            sub.remove(sub.size() - 1);
        }
    }
}