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
    //we should not use preorder, this will not delete node repeatedly
    // public TreeNode removeLeafNodes(TreeNode root, int target) {
    //     if (root == null) {
    //         return root;
    //     }
    //     if (root.left == null && root.right == null && root.val == target) {
    //         return null;
    //     }
    //     root.left = removeLeafNodes(root.left, target);
    //     root.right = removeLeafNodes(root.right, target);
    //     return root;
    // }
    
    //think in postorder
    /*
         1
       2   3
     2    2  4
    */
    public TreeNode removeLeafNodes(TreeNode root, int target){
        if (root == null) {
            return root;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        return root.left == null && root.right == null && root.val == target ? null : root;
    }
}