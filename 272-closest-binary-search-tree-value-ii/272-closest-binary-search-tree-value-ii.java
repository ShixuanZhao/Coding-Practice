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
    1 2 3 4 5 k = 2
        - -
    */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        //如果用List改成LinkedList， API;removeFirst(), addLast()
        List<Integer> res = new LinkedList<>();
        dfs(root, target, k, res);
        return res;
    }
    
    private void dfs(TreeNode root, double target, int k, List<Integer> res) {
        if (root == null) {
            return;
        }
        dfs(root.left, target, k, res);
        if (res.size() < k) {
            res.add(root.val);
        } else if (Math.abs(target - root.val) < Math.abs(target - res.get(0))){
            res.remove(0);
            res.add(root.val);
        } else {
            return;
        }
        dfs(root.right, target, k, res);
    }
}