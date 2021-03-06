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
//     public TreeNode bstFromPreorder(int[] preorder) {
//         return helper(preorder, 0, preorder.length - 1);
//     }
    
//     private TreeNode helper(int[] preorder, int left, int right) {
//         if (left > right) {
//             return null;
//         }
//         TreeNode root = new TreeNode(preorder[left]);
//         int index = left + 1;
//         //boundary index == right is ok, means all left node no right node
//         while (index <= right && preorder[index] < preorder[left]) {
//             index++;
//         }
//         root.left = helper(preorder, left + 1, index - 1);
//         root.right = helper(preorder, index, right);
//         return root;
//     }
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode build(int[] preorder, int low, int high) {
        if (index == preorder.length) {
            return null;
        }
        int val = preorder[index];
        if (val < low || val > high) {
            return null;
        }
        //index++ must be here
        index++;
        TreeNode root = new TreeNode(val);
        root.left = build(preorder, low, val);
        root.right = build(preorder, val, high);
        return root;
    }
}