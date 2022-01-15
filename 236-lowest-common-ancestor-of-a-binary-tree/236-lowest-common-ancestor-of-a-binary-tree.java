/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
    corner: p or q is not in the tree
    left:lowestCommonAncestor(root.left....)
    right:lowestCommonAncestor(root.right ...)
    case1:left == null && right == null return null
    case2:either left or right is not null. we return the not none node
    case3:both left and right is not null, return root (LCA)
    base case:root == null || root == p || root == q
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //case3
        if (left != null && right != null) {
            return root;
        }
        //case1&2
        return left == null ? right : left;
    }
}