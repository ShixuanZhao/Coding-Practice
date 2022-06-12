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
    //check each root of subtree, whether it is the same as subRoot tree
    //O(n^2)
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (isSame(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }
        return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
    }
    
//     public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//         String s1 = getString(root);
//         String s2 = getString(subRoot);
//         return s1.indexOf(s2) == -1 ? false : true;
//     }
    
//     //corner case: 12 2 return false
//     private String getString(TreeNode root) {
//         if (root == null) {
//             return "#";
//         }
//         StringBuilder sb = new StringBuilder();
        
//         sb.append("(");
//         sb.append(root.val);
//         sb.append(")");
        
//         sb.append("(");
//         sb.append(getString(root.left));
//         sb.append(")");
        
//         sb.append("(");
//         sb.append(getString(root.right));
//         sb.append(")");
//         return sb.toString();
//     }
}