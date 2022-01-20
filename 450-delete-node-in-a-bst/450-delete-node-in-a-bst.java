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
        step1:find the node that we want to delete
        step2:delete
        3cases: 1.the deleted node have no children, return null to his parent
                2. have one child, return the child that is not null
                3.have two children, eg.3 we can find the largest node in its left subtree and replace the deleted node
    */
    public TreeNode deleteNode(TreeNode root, int key) {
        //corner case
        if (root == null) {
            return root;
        }
        //step1
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            //step2
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null || root.right == null) {
                return root.left == null ? root.right : root.left;
            } else {
                //find max int left subtree
                // root.val = findMax(root.left);
                // root.left = deleteNode(root.left, root.val);
                //如果不能改变节点的值
                //右子树只有一个node，不用删除右子树的最小值
                if (root.right.left == null) {
                    root.right.left = root.left;
                    return root.right;
                }
                //右子树的最小值
                TreeNode large = findLarge(root.right);
                large.left = root.left;
                large.right = root.right;
                return large;
            }
        }
        return root;
    }
    
    private TreeNode findLarge(TreeNode root) {
        TreeNode prev = null;
        TreeNode cur = root;
        while (cur.left != null) {
            prev = cur;
            cur = cur.left;
        }
        prev.left = cur.right;
        return cur;
    }
    
    private int findMax(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }
}