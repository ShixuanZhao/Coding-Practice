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
    //M1:find LCA, and add the distance to LCA
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lca = LCA(root, p, q);
        return dis(lca, p) + dis(lca, q);
    }
    
    private TreeNode LCA(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
    
    private int dis(TreeNode root, int node) {
        Queue<TreeNode> q = new LinkedList<>();
        int distance = 0;
        q.offer(root);
        while(!q.isEmpty()) {
            int sz = q.size();
            for(int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                if(cur.val == node) return distance;
                else {
                    if(cur.left != null) q.offer(cur.left);
                    if(cur.right != null) q.offer(cur.right);
                }
            }
            distance++;
        }
        
        return -1;
    }
}