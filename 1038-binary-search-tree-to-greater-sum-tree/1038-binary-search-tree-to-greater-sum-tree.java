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
    public TreeNode bstToGst(TreeNode root) {
        int[] pre = new int[1];
        return dfs(root, pre);
    }
    
    //pre store the greater sum because we traverse right node, root, and then left node
    //we make sure it is in decreasing order
    private TreeNode dfs(TreeNode root, int[] pre) {
        if (root == null) {
            return root;
        }
        dfs(root.right, pre);
        root.val = root.val + pre[0];
        pre[0] = root.val;
        dfs(root.left, pre);
        return root;
    }
}