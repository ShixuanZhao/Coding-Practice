/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/*
    high level:dfs
    Map<Integer, Integer> prefixSum
    prefixSum:(0, 1) (10, 1) (15, 1)
    10 5 3   curSum = 18 check (curSum - targetSum) in prefixSum
             18 - 8 = 10  find a valid path 
    void dfs(TreeNode root, int targetSum, int curSum, Map<Integer, Integer> prefixSum, int[] res)
*/
class Solution {
    int res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        //<prefixSum, freq>
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        dfs(root, targetSum, preSum, 0);
        return res;
    }
    
    private void dfs(TreeNode root, int targetSum, Map<Integer, Integer> preSum, int sum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        res += preSum.getOrDefault(sum - targetSum, 0);
        preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        dfs(root.left, targetSum, preSum, sum);
        dfs(root.right, targetSum, preSum, sum);
        //sum is primitive type, not object
        //sum -= root.val;
        preSum.put(sum, preSum.getOrDefault(sum, 0) - 1);
    }
}