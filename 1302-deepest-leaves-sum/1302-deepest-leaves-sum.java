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
    // public int deepestLeavesSum(TreeNode root) {
    //     Queue<TreeNode> q=new LinkedList<>();
    //     int sum=0;
    //     q.offer(root);
    //     while (!q.isEmpty()) {
    //         int size = q.size();
    //         //re-initialize sum is important
    //         sum = 0;
    //         for (int i = 0; i < size; i++) {
    //             TreeNode cur = q.poll();
    //             sum += cur.val;
    //             if (cur.left != null) {
    //                 q.offer(cur.left);
    //             }
    //             if (cur.right != null) {
    //                 q.offer(cur.right);
    //             }
    //         }
    //     }
    //     return sum;
    // }
    
    //dfs
    //maintain global var: res and curMaxLevel
    int res = 0;
    int maxLevel = 0;
    public int deepestLeavesSum(TreeNode root) {
        helper(root, 0);
        return res;
    }
    
    private void helper(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level == maxLevel) {
            res += root.val;
        } else if (level > maxLevel) {
            maxLevel = level;
            res = root.val;
        }
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}