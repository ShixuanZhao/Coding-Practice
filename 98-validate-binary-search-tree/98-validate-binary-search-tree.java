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
         5
(min,5)1   4(5, max)    every node (min, max)
         3  6            if the whole tree is a bst, for every node, min < cur.val < max
    */
//     public boolean isValidBST(TreeNode root) {
//        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
//     }
    
//     private boolean helper(TreeNode root, long min, long max) {
//         if (root == null) {
//             return true;
//         }
//         if (root.val <= min || root.val >= max) {
//             return false;
//         }
//         return helper(root.left, min, root.val) && helper(root.right, root.val, max);
//     }
    //the above solution is recursion, it can casuse stackoverflow, we can iterative way to sovle it by inorder traversal
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.offerFirst(root);
                root = root.left;
            }
            root = stack.pollFirst();
            if (prev != null && root.val <= prev.val) {
                return false;
            }
            //!!!
            prev = root;
            root = root.right;
        }
        return true;
    }
}