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
    public List<Integer> rightSideView(TreeNode root) {
        //BFS
        // List<Integer> res = new LinkedList<>();
        // if (root == null) {
        //     return res;
        // }
        // Queue<TreeNode> queue = new LinkedList<>();
        // queue.offer(root);
        // while (!queue.isEmpty()) {
        //     int size = queue.size();
        //     while (size > 0) {
        //         TreeNode cur = queue.poll();
        //         if (size == 1) {
        //             res.add(cur.val);
        //         }
        //         if (cur.left != null) {
        //             queue.offer(cur.left);
        //         }
        //         if (cur.right != null) {
        //             queue.offer(cur.right);
        //         }
        //         size--;
        //     }
        // }
        // return res;

        //dfs
        List<Integer> res = new LinkedList<>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int level) {
        if (root == null) {
            return;
        }
        if (res.size() == level) {
            res.add(root.val);
        }
        helper(root.right, res, level + 1);
        helper(root.left, res, level + 1);
    }
}