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
    List<String> res = new ArrayList<>();
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        Collections.sort(res);
        return res.get(0);
    }
    
    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        char c = (char)(root.val + 'a');
        sb.append(c);
        if (root.left == null && root.right == null) {
            //this is wrong because we do not want to change sb, we need it backtrack!!
            //so we need to keep sb unchange
            //String s = sb.reverse().toString();
            String s = new StringBuilder(sb).reverse().toString();
            res.add(s);
        } else {
            dfs(root.left, sb);
            dfs(root.right, sb);
        }
        //backtrack here!!
        sb.setLength(sb.length() - 1);
    }
    
}