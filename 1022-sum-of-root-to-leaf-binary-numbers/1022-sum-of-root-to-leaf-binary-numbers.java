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
    /*
    We recursively pass the current value of path to the children.
If root == null, no value, return 0.
If root != null,
we double the value from its parent and add the node's value,
like the process of transforming base 2 to base 10.
In the end of recursion,
if root.left == root.right == null,
return the current val.
    */
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        // if (root.left == null && root.right == null) {
        //     return root.val;
        // }
        //preorder
        val = val * 2 + root.val;
        //calculate the sum
        //if the leaf node, we return the val
        return root.left == null && root.right == null ?  val : dfs(root.left, val) + dfs(root.right, val);
    }
}