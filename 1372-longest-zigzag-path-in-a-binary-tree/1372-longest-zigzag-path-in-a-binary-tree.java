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
    int max;
    public int longestZigZag(TreeNode root) {
        dfs(root);
        return max - 1;
    }
    
    //we should get res from left and right
    private int[] dfs(TreeNode root) {
        int[] res = new int[2]; //{leftSum, rightSum}
        if (root == null) {
            return res;
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        res[0] = left[1] + 1;
        res[1] = right[0] + 1;
        max = Math.max(max, Math.max(res[0], res[1]));
        return res;
    }
}