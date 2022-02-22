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
//     Quite similar problem as this one 968.Binary Tree Cameras.
// Write a dfs helper, return the number of coins given to the parent.
    int res = 0;
    public int distributeCoins(TreeNode root) {
        helper(root);
        return res;
    }
    
    //postorder:return how many coins do the cur node need to transmit to its parent
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        res += Math.abs(left) + Math.abs(right);
        return left + right + root.val - 1;
    }
}