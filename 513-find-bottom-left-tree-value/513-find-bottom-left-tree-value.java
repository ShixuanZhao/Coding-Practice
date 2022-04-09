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
//     public int findBottomLeftValue(TreeNode root) {
//         if (root == null) return 0;
        
//         int result = 0;
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
        
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             for (int i = 0; i < size; i++) {
//                 TreeNode node = queue.poll();
//                 //Only additional step is to remember the first element of each level.
//                 if (i == 0) result = node.val;
//                 if (node.left != null) queue.add(node.left);
//                 if (node.right != null) queue.add(node.right);
//             }
//         }
        
//         return result;
//     }
    
    //bfs先遍历right node再left node
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            root = q.poll();
            if (root.right != null) {
                q.offer(root.right);
            }
            if (root.left != null) {
                q.offer(root.left);
            }
        }
        return root.val;
    }
}