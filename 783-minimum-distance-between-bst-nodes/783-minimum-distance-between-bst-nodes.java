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
    public int minDiffInBST(TreeNode root) {
        int[] res = new int[] {Integer.MAX_VALUE};
        TreeNode[] prev = new TreeNode[1];
        dfs(root, res, prev);
        return res[0];
    }
    
    private void dfs(TreeNode root, int[] res, TreeNode[] prev) {
        if (root == null) {
            return;
        }
        dfs(root.left, res, prev);
        if (prev[0] != null) {
            res[0] = Math.min(res[0], root.val - prev[0].val);
        }
        prev[0] = root;
        dfs(root.right, res, prev);
    }
}