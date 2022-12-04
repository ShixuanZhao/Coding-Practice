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
    //The height of a node is the number of edges from the node to the deepest
        //leaf.
        //height就是从当前节点往下看的最远距离
        //we find the height of each node is the index in the result list
//     public List<List<Integer>> findLeaves(TreeNode root) {
//         List<List<Integer>> res = new ArrayList<>();
//         getHeight(root, res);
//         return res;
//     }
    
    //use this method, we do not remove node actually
    //寻找这一类节点的共同特征：就是他底下的节点数量都一样
//     private int getHeight(TreeNode root, List<List<Integer>> res) {
//         if (root == null) {
//             return -1;
//         }
//         int left = getHeight(root.left, res);
//         int right = getHeight(root.right, res);
//         int height = Math.max(left, right) + 1;
    //when first add, height is the size
//         if (height == res.size()) {
//             res.add(new ArrayList<>());
//         }
//         res.get(height).add(root.val);
//         return height;
//     }
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        while (root != null) {
            List<Integer> temp = new ArrayList<>();
            root = deleteNode(root, temp);
            res.add(temp);
        }
        return res;
    }
    
    //delete leave node, and return the root after deletion, and put the leaf node into temp list 
    private TreeNode deleteNode(TreeNode root, List<Integer> temp) {
        if (root == null) {
            return root;
        }
        TreeNode left = deleteNode(root.left, temp);
        TreeNode right = deleteNode(root.right, temp);
        if (root.left == null && root.right == null) {
            temp.add(root.val);
            return null;
        }
        root.left = left;
        root.right = right;
        return root;
    }
}