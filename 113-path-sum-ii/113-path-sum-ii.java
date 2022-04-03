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
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        dfs(root, targetSum, res, cur, 0);
        return res;
    }
    
    private void dfs(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> cur, int sum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        cur.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                res.add(new LinkedList<>(cur));
            }
        }
        dfs(root.left, targetSum, res, cur, sum);
        dfs(root.right, targetSum, res, cur, sum);
        sum -= root.val;
        cur.remove(cur.size() - 1);
    }
}