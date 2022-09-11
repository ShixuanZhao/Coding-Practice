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
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return res;
    }
    
    //the longest path including root
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftRes = 0;
        int rightRes = 0;
        if (root.left != null && root.val == root.left.val - 1) {
            leftRes = left + 1;
        } else {
            leftRes = 1;
        }
        if (root.right != null && root.right.val - 1 == root.val) {
            rightRes = right + 1;
        } else {
            rightRes = 1;
        }
        int len = Math.max(leftRes, rightRes);
        res = Math.max(res, len);
        return len;
    }
}