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
        high level: recursion
        3               for each node in the big tree(preOrder traverse), check whether two tree is the same
      4   5     4      how to judge the whether two tree is identical:
1(l)   2(r)  1(l)  2(r)   root == subroot && left && right  return true
                                    else                    return false
                                    base case:either is null, return false
                                              both is null, return true
    */                      
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        //遍历每一个节点，在当前层检查以roor为根的子树和subtree一样不一样， PreOrder
        if (sameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private boolean sameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }
        return sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right);
    }
}