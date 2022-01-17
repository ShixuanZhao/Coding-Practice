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
    public int sumNumbers(TreeNode root) {
        int[] res = new int[1];
        helper(root, 0, res);
        return res[0];
    }
    
    private void helper(TreeNode root, int sum, int[] res) {
        if (root == null) {
            // res[0] += sum;
            return;
        }
        int curSum = sum * 10 + root.val;
        //we must update the sum at the leaf node
        if (root.left == null && root.right == null) {
            res[0] += curSum;
        }
        helper(root.left, curSum, res);
        helper(root.right, curSum, res);
    }
}