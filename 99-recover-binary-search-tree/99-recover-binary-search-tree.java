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
    public void recoverTree(TreeNode root) {
        TreeNode[] prev = new TreeNode[] {new TreeNode(Integer.MIN_VALUE)};
        TreeNode[] e1 = new TreeNode[1];
        TreeNode[] e2 = new TreeNode[1];
        inOrder(root, prev, e1, e2);
        //做value交换因为题目中说了是值被交换了
        int temp = e1[0].val;
        e1[0].val = e2[0].val;
        e2[0].val = temp;
    }
    
    private void inOrder(TreeNode root, TreeNode[] prev, TreeNode[] e1, TreeNode[] e2) {
        if (root == null) {
            return;
        }
        inOrder(root.left, prev, e1, e2);
        if (root.val < prev[0].val) {
            if (e1[0] == null) {
                e1[0] = prev[0];
            } 
            e2[0] = root;     
        }
        prev[0] = root;
        inOrder(root.right, prev, e1, e2);
    }
}