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
    //preOrder直上直下的路径不带返回值的写法
//     public int maxAncestorDiff(TreeNode root) {
//         //在所有直上直下的路径上找到maxDiff
//         //当前层update，max和min
//         //base case的时候更新maxDiff
//         int[] maxDiff = new int[1];
//         maxAncestorDiff(root, maxDiff, Integer.MAX_VALUE, Integer.MIN_VALUE);
//         return maxDiff[0];
//     }
    
//     //dfs
//     private void maxAncestorDiff(TreeNode root, int[] maxDiff, int min, int max) {
//         if (root == null) {
//             maxDiff[0] = Math.max(max - min, maxDiff[0]);
//             return;
//         }
//         min = Math.min(min, root.val);
//         max = Math.max(max, root.val);
//         maxAncestorDiff(root.left, maxDiff, min, max);
//         maxAncestorDiff(root.right, maxDiff, min, max);
//     }
    
    //三部曲的写法
    public int maxAncestorDiff(TreeNode root) {
        //三部曲
        return maxAncestorDiff(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    //draw recursion tree
    /*
          8(min:8, max:8)
    3(3, 8)       10(8, 10)
    / \              \
 1(7)     6(3, 8) (return 5)
     /  \
     4    7
     |
     null(return:8 - 3 = 5)
     节点1返回7，节点三 compare 7 and 5 所以返回7 
    */
    private int maxAncestorDiff(TreeNode root, int min, int max) {
        if (root == null) {
            return max - min;
        }
        //update min and max up to down直上直下的一条path
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        int left = maxAncestorDiff(root.left, min, max);
        int right = maxAncestorDiff(root.right, min, max);
        return Math.max(left, right);
    }
}