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
//     public TreeNode pruneTree(TreeNode root) {
//         if (root == null) {
//             return root;
//         }
//         containOne(root);
//         return root;
//     }
    
//     private boolean containOne(TreeNode root) {
//         if (root == null) {
//             return false;
//         }
//         boolean left = containOne(root.left);
//         boolean right = containOne(root.right);
//         if (!left) {
//             root.left = null;
//         }
//         if (!right) {
//             root.right = null;
//         }
//         return root.val == 1 || left || right;
//     }
    // This is a kind of divide and conquer process. Beginning from the bottom, for null nodes we just return null. If the node is 1, or if there is any child of it is not null, we return itself, otherwise we return null. In this way, only when a node has two null children, and itself is also 0, we return null and the null will be assigned to its parent’s left/right, so we pruned the tree.
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return (root.val == 1 || root.left != null || root.right != null) ? root : null;
    }
}