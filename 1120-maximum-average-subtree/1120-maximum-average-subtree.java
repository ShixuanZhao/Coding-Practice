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
    public double maximumAverageSubtree(TreeNode root) {
        //return multiple value
          //    12   (valueSum = 5 + 10 + 12, nodeCount = 1 + 1 + 1, maxAverage = Max(x, 5, 10) = 10)
          // 5      10 (valueSum = 10, nodeCount = 1, maxAverage = 10)
        double[] maxAverage = new double[] {Integer.MIN_VALUE};
        helper(root, maxAverage);
        return maxAverage[0];
    }
    //res[0]:sum res[1]: cnt(the size of subtree)
    private int[] helper(TreeNode root, double[] maxAverage) {
        if (root == null) {
            return new int[2];
        }
        //res is in the cur node layer, what we should return to its upper level
        int[] res = new int[2];
        int[] left = helper(root.left, maxAverage);
        int[] right = helper(root.right, maxAverage);
        res[0] = root.val + left[0] + right[0];
        res[1] = 1 + left[1] + right[1];
        //update the maxAverage
        maxAverage[0] = Math.max(maxAverage[0], res[0] / (double) (res[1]));
        return res;
    }
}