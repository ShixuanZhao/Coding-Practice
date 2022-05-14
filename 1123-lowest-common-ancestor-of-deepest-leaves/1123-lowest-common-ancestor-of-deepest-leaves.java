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
    //信息传递
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root, 0).node;
    }
    
    private Node dfs(TreeNode root, int depth) {
        if (root == null) {
            return new Node(root, depth);
        }
        Node left = dfs(root.left, depth + 1);
        Node right = dfs(root.right, depth + 1);
        if (left.depth == right.depth) {
            //return left.depth
            return new Node(root, left.depth);
        }
        return left.depth > right.depth ? left : right;
    }
    
    class Node {
        TreeNode node;
        int depth;
        
        public Node(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}