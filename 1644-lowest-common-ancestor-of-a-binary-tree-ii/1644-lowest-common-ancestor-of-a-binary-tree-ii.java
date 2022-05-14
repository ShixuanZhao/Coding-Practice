/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (lowestCommonAncestor2(root, p, p) == null || lowestCommonAncestor2(root, q, q) == null) {
            return null;
        }
        return lowestCommonAncestor2(root, p, q);
    }
    
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        //case3
        if (left != null && right != null) {
            return root;
        }
        //case1&2
        return left == null ? right : left;
    }
}