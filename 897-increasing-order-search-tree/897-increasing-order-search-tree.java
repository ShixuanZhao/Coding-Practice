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
    public TreeNode increasingBST(TreeNode root) {
        TreeNode[] head = new TreeNode[1];
        TreeNode[] prev = new TreeNode[1];
        increasingBST(root, head, prev);
        return head[0];
    }
    
    private void increasingBST(TreeNode root, TreeNode[] head, TreeNode[] prev) {
        if (root == null) {
            return;
        }
        increasingBST(root.left, head, prev);
        if (head[0] == null) {
            head[0] = root;
        }
        if (prev[0] != null) {
            prev[0].right = root;
        }
        root.left = null;
        prev[0] = root;
        increasingBST(root.right, head, prev);
    }
}