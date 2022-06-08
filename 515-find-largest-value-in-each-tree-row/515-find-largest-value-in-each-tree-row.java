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
    public List<Integer> largestValues(TreeNode root) {
        // List<Integer> res = new LinkedList<>();
        // if (root == null) {
        //     return res;
        // }
        // Queue<TreeNode> queue = new LinkedList<>();
        // queue.offer(root);
        // while (!queue.isEmpty()) {
        //     int size = queue.size();
        //     int max = Integer.MIN_VALUE;
        //     for (int i = 0; i < size; i++) {
        //         TreeNode cur = queue.poll();
        //         max = Math.max(max, cur.val);
        //         if (cur.left != null) {
        //             queue.offer(cur.left);
        //         }
        //         if (cur.right != null) {
        //             queue.offer(cur.right);
        //         }
        //     }
        //     res.add(max);
        // }
        // return res;

        //dfs
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        helper(root, res, 0);
        return res;
    }
    
    //dfs层序遍历就是维持一个参数level
    private void helper(TreeNode root, List<Integer> res, int level) {
        if (root == null) {
            return;
        }
        //第一次访问当前层
        if (res.size() == level) {
            res.add(root.val);
        }
        if (root.val > res.get(level)) {
            res.set(level, root.val);
        }
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    
    }
}