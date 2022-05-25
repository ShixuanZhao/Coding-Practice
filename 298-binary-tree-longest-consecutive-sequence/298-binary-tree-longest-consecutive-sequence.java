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
    int res = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return res;
    }
    
    //the longest path including root
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (root.left != null && root.left.val - 1 == root.val) {
            //cur left, including root
            left++;
        } else {
            left = 1;
        }
        
        if (root.right != null && root.right.val - 1 == root.val) {
            right++;
        } else {
            right = 1;
        }
        int len = Math.max(left, right);
        res = Math.max(res, len);
        return len;
    }
}