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
        case1:low < root.val < high go to left subtree
        case2:root.val < low go to right subtree
        case3:root.val > high go to left subtree
    */
//     public int rangeSumBST(TreeNode root, int low, int high) {
//         int[] sum = new int[1];
//         inOrder(root, low, high, sum);
//         return sum[0];
//     }
    
//     private void inOrder(TreeNode root, int low, int high, int[] sum) {
//         if (root == null) {
//             return;
//         }
//         inOrder(root.left, low, high, sum);
//         if (low <= root.val && root.val <= high) {
//             sum[0] += root.val;
//         } else if (root.val > high) {
//             return;
//         }
//         inOrder(root.right, low, high, sum);
//     }
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        return root.val + rangeSumBST(root.right, low, high) + rangeSumBST(root.left, low, high);
    }
}