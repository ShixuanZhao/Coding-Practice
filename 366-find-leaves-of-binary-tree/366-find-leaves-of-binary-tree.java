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
    public List<List<Integer>> findLeaves(TreeNode root) {
        //The height of a node is the number of edges from the node to the deepest
        //leaf.
        //height就是从当前节点往下看的最远距离
        //we find the height of each node is the index in the result list
        List<List<Integer>> res = new LinkedList<>();
        getHeight(root, res);
        return res;
    }
    
    //use this method, we do not remove node actually
    private int getHeight(TreeNode root, List<List<Integer>> res) {
       if (root == null) {
           return -1;
       }
        //use postOrder 触底反弹这样顺序才是对的
        int left = getHeight(root.left, res);
        int right = getHeight(root.right, res);
        int level = Math.max(left, right) + 1;
        if (level == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        return level;
    }
    
    
//      public List<List<Integer>> findLeaves(TreeNode root) {
//          List<List<Integer>> res = new LinkedList<>();
//          while (root != null) {
//              List<Integer> temp = new LinkedList<>();
//              deleteNode(root, temp);
//              res.add(temp);
//          }
//          return res;
//      }
    
//     private TreeNode deleteNode(TreeNode root, List<Integer> temp) {
//         if (root == null) {
//             return null;
//         }
//         TreeNode left = deleteNode(root.left, temp);
//         TreeNode right = deleteNode(root.right, temp);
//         if (root.left == null && root.right == null) {
//             temp.add(root.val);
//             return null;
//         }
//         root.left = left;
//         root.right = right;
//         return root;
//     }
}