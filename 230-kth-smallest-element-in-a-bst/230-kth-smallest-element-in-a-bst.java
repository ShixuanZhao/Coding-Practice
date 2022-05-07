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
    public int kthSmallest(TreeNode root, int k) {
        //inOrder traverse
        int[] cnt = new int[1];
        int[] res = new int[1];
        helper(root, k, cnt, res);
        return res[0];
    }
    
    private void helper(TreeNode root, int k, int[] cnt, int[] res) {
        if (root == null) {
            return;
        }
        helper(root.left, k, cnt, res);
        cnt[0]++;
        if (cnt[0] == k) {
            res[0] = root.val;
            return;
        }
        helper(root.right, k, cnt, res);
    }
    
    //iterative
    // public int kthSmallest(TreeNode root, int k) {
    //     Deque<TreeNode> stack = new ArrayDeque<>();
    //     while (!stack.isEmpty() || root != null) {
    //         while (root != null) {
    //             stack.offerFirst(root);
    //             root = root.left;
    //         }
    //         root = stack.pollFirst();
    //         if (--k == 0) {
    //             break;
    //         }
    //         root = root.right;
    //     }
    //     return root.val;
    // }
}