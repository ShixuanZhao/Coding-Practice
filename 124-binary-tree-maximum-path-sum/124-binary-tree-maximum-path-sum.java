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
    public int maxPathSum(TreeNode root) {
        int[] max = new int[] {Integer.MIN_VALUE};
        maxPathSum(root, max);
        return max[0];
    }
    
    private int maxPathSum(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, maxPathSum(root.left, max));
        int right = Math.max(0, maxPathSum(root.right, max));
        max[0] = Math.max(max[0], left + right + root.val);
        return Math.max(left, right) + root.val;
    }

    
//     public int maxPathSum(TreeNode root) {
//         int[] max = new int[] {Integer.MIN_VALUE};
//         String[] path = new String[1];
//         maxPathSum(root, max, path);
//         System.out.println(path[0]);
//         return max[0];
//     }
    
//     private Pair maxPathSum(TreeNode root, int[] max, String[] path) {
//         if (root == null) {
//             return new Pair(0, "");
//         }
//         Pair res = new Pair(0, "");
//         int left = Math.max(0, maxPathSum(root.left, max, path).sum);
//         int right = Math.max(0, maxPathSum(root.right, max, path).sum);
//         StringBuilder sb = new StringBuilder();
//         if (left + right + root.val > max[0]) {
//             max[0] = left + right + root.val;
//             path[0] = sb.append(maxPathSum(root.left, max, path).s).append("-").append(root.val).append("-").append(maxPathSum(root.right, max, path).s).toString();
//             //System.out.println(path);
//         }
//         if (left > right) {
//             res.sum = left + root.val;
//             res.s = maxPathSum(root.left, max, path).s + "-" + String.valueOf(root.val);
//         } else {
//             res.sum = right + root.val;
//             res.s = String.valueOf(root.val) + "-" + maxPathSum(root.right, max, path).s;
//         }
//         return res;
//     }
    
//     class Pair {
//         int sum;
//         String s;
        
//         Pair(int sum, String s) {
//             this.sum = sum;
//             this.s = s;
//         }
//     }
}