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
    public boolean isCousins(TreeNode root, int x, int y) {
        //cousin离他们的lca距离相等，但是距离至少是2
        boolean[] flag = new boolean[1];
        isCousins(root, x, y, flag, 0);
        return flag[0];
    }
    
    //return is the level of x or y
    private int isCousins(TreeNode root, int x, int y, boolean[] flag, int level) {
        if (root == null) {
            return 0;
        }
        //if find x or y return its level
        if (root.val == x || root.val == y) {
            return level;
        }
        int left = isCousins(root.left, x, y, flag, level + 1);
        int right = isCousins(root.right, x, y, flag, level + 1);
        if (left == right && left - level > 1) {
            flag[0] = true;
        }
        return left > right ? left : right;
    }
}