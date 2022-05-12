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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return dfs(root, val, depth, 1);
    }
    
    //return the root of the tree after adding one row
    //two corner case: curDepth == 1 and curDepth = depth -1
    //top-down preorder
    private TreeNode dfs(TreeNode root, int val, int depth, int curDepth) {
        if (root == null) {
            return root;
        }
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        if (curDepth == depth - 1) {
            TreeNode left = new TreeNode(val);
            TreeNode right = new TreeNode(val);
            left.left = root.left;
            right.right = root.right;
            root.left = left;
            root.right = right;
            return root;
        }
        root.left = dfs(root.left, val, depth, curDepth + 1);
        root.right = dfs(root.right, val, depth, curDepth + 1);
        return root;
    }
}