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
    int res = 0;
    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }
    
    //to justify the given root is a univalue subtree
    private boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = dfs(root.left);
        boolean right = dfs(root.right);
        //left node is null or val is equal
        boolean leftOk = root.left == null || left && root.val == root.left.val;
        boolean rightOk = root.right == null || right && root.val == root.right.val;
        if (leftOk && rightOk) {
            res++;
            return true;
        }
        return false;
    }
}