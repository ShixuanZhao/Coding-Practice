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
    //find the common ancerstor first 
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode ancestor = lowestCommonAncestor(root, startValue, destValue);
        StringBuilder sb1 = new StringBuilder();
        getPath(ancestor, startValue, sb1);
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < sb1.length(); i++)
            sb2.append("U");
        StringBuilder sb3 = new StringBuilder();
        getPath(ancestor, destValue, sb3);
        return sb2.toString() + sb3.reverse().toString();
    }
    
    private TreeNode lowestCommonAncestor(TreeNode root, int s, int d) {
        if (root == null) {
            return root;
        }
        if (root.val == s || root.val == d) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, s, d);
        TreeNode right = lowestCommonAncestor(root.right, s, d);
        
        //current root contains both p and q, is the lca node, and this is postorder
        if (left != null && right != null)
            return root;
        
        //left or right at least one of them contains lca
        return left == null ? right : left;
    }
    
    //preorder because of backtracking, the order is reversed
    private boolean getPath(TreeNode root, int node, StringBuilder sb) {
        if (root == null) {
            return false;
        }
        if (root.val == node) {
            return true;
        }
        if (getPath(root.left, node, sb)) {
            sb.append('L');
            return true;
        }
        
        if (getPath(root.right, node, sb)) {
            sb.append('R');
            return true;
        }
        return false;
    }
}