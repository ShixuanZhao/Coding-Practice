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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<TreeNode> set = new HashSet<>();
        for (TreeNode node : nodes) {
            set.add(node);
        }
        return LCA(root, set);
    }
    
    private TreeNode LCA(TreeNode root, Set<TreeNode> set) {
        if (root == null) {
            return root;
        }
        if (set.contains(root)) {
            return root;
        }
        TreeNode left = LCA(root.left, set);
        TreeNode right = LCA(root.right, set);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}