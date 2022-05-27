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

public class Solution {
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return max;
    }
    
    //int[0]:increasing from root int[1]:decreasing from root
    public int[] helper(TreeNode root){
        if(root == null) return new int[]{0,0};
        int[] left = helper(root.left);
        int[] right= helper(root.right);
        int inc = 1, des = 1;
        if(root.left != null){
            if(root.val - root.left.val == 1){
                des = left[1]+1;
            }else if(root.val - root.left.val == -1){
                inc = left[0]+1;
            }
        }
        if(root.right != null){
            if(root.val - root.right.val == 1){
                //向上返回，只能取最大的一边，这样才是path
                des = Math.max(des,right[1]+1);
            }else if(root.val - root.right.val == -1){
                inc = Math.max(inc,right[0]+1);
            }
        }
        //包含root的递增序列和递减序列（从root开始），整体合在一起就是单调的
        max = Math.max(max,inc+des-1);
        return new int[]{inc,des};
    }
}
