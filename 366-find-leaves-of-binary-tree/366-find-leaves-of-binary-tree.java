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
    //寻找这一类节点的共同特征：就是他底下的节点数量都一样
    private int getHeight(TreeNode root, List<List<Integer>> res) {
       if (root == null) {
           return -1;
       }
        //use postOrder 触底反弹这样顺序才是对的
        //bottom up height相同的在一层
        int left = getHeight(root.left, res);
        int right = getHeight(root.right, res);
        //level is the height
        //4 5 3 的height是0
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