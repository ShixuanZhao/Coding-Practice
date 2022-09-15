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
/*
    eg.at the node 3, we need to find whether its left subtree and right subtree are bst
    and we need to know the max value in its left subtree(a) and the min value in thr right subtree(b)
    if a < root.val < b.val, the tree that root == 3 is a BST
    and we can calculate the sum, sum = leftSum + root.val + rightSum
    
    corner case:
    Input: root = [-4,-2,-5]
    Output: 0
    Explanation: All values are negatives. Return an empty BST.
*/
class Solution {
    public int maxSumBST(TreeNode root) {
        int[] maxSum = new int[] {Integer.MIN_VALUE};
        helper(root, maxSum);
        if (maxSum[0] < 0) {
            return 0;
        }
        return maxSum[0];
    }
    
    //return int[4] int[0]:whether the subtree which root is "root" is BST
    //int[1]: the maxValue in subtree which root is "root"
    //int[2]: the minValue in subtree which root is "root"
    //int[3]: the sum of the subtree which root is "root"
    private int[] helper(TreeNode root, int[] maxSum) {
        if (root == null) {
            return new int[] {1, Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }
        int[] left = helper(root.left, maxSum);
        int[] right = helper(root.right, maxSum);
        //how to return to upper level
        int[] res = new int[4];
        if (left[0] == 1 && right[0] == 1 && left[1] < root.val && root.val < right[2]) {
            res[0] = 1;
            res[1] = Math.max(right[1], root.val);
            res[2] = Math.min(left[2], root.val);
            res[3] = left[3] + root.val + right[3];
            maxSum[0] = Math.max(maxSum[0], res[3]);
        } else {
            res[0] = 0;
        }
        return res;
    }
}