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
        if (root == null) {
            return res;
        }
        List<Integer> cur = new LinkedList<>();
        helper(root, targetSum, res, cur);
        return res;
    }
    
    private void helper(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> cur) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;
        cur.add(root.val);
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new LinkedList<>(cur));
        }
        helper(root.left, targetSum, res, cur);
        helper(root.right, targetSum, res, cur);
        targetSum += root.val;
        cur.remove(cur.size() - 1);
    }
}